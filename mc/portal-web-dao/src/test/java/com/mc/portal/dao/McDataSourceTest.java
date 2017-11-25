package com.mc.portal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mc.portal.cxt.McDAOContextConfiguration;
import com.mc.portal.vo.Db;
import com.mc.portal.vo.HelpCategory;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={McDAOContextConfiguration.class})
@Slf4j
public class McDataSourceTest{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCreateJdbcTemplate(){
		log.debug("local veriable jdbcTemplate : {}",jdbcTemplate);
		Assert.assertNotNull(jdbcTemplate);
		jdbcTemplate.query("select * from mysql.user",new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				log.info("Host : {} \t User : {} \t Password : {}",rs.getString(1),rs.getString(2),rs.getString(3));
			}
		});
	}
	
	@Autowired
	private IDbDao dbDao;
	
	@Test
	public void testDbDao(){
		Assert.assertNotNull(dbDao);
		List<Db> list = dbDao.getDb();
		Assert.assertNotNull(list);
		log.info("查询出db数量：{}",list.size());
	}
	
	@Autowired
	private IHelpCategoryDao helpCategoryDao;
	
	@Test
	public void testHelpCategoryDao(){
		Assert.assertNotNull(helpCategoryDao);
		List<HelpCategory> list = helpCategoryDao.getHelpCategory();
		Assert.assertNotNull(list);
		log.info("查询出HelpCategoryDao数量：{}",list.size());
	}
}