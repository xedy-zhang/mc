/**
 * 
 */
package com.mc.portal.cxt;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HANTY
 *
 */

@Slf4j
@Configuration
@MapperScan(basePackages={"com.mc.**.dao"})
@PropertySource(value={"classpath:/META-INF/properties/jdbc.properties"})
public class McDAOContextConfiguration implements ApplicationContextAware{
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${jdbc.pwd}")
	private String password;
	
	@Value("${jdbc.user}")
	private String userName;
	
	@Value("${jdbc.driver}")
	private String driverClass;
	
	@Bean(name="McDataSource",destroyMethod="close")
	public BoneCPDataSource createDataSource(){
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		log.info("driverClass : {} , jdbcUrl : {} , userName : {} , password : {} .",this.driverClass,this.jdbcUrl,this.userName,this.password);
		boneCPDataSource.setJdbcUrl(jdbcUrl);
		boneCPDataSource.setPassword(password);
		boneCPDataSource.setUser(userName);
		boneCPDataSource.setDriverClass(driverClass);
		log.info(boneCPDataSource.getConfig().toString());
		return boneCPDataSource;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		BoneCPDataSource dataSource = applicationContext.getBean("McDataSource", BoneCPDataSource.class);
		log.info("jdbcTemplate创建前获取dataSource为：{}",dataSource);
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	@Bean(name="sqlSessionFactoryBean")
	public SqlSessionFactoryBean createSqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		BoneCPDataSource dataSource = applicationContext.getBean("McDataSource", BoneCPDataSource.class);
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}
	
	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
