/**
 * 
 */
package com.mc.portal.cxt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HANTY
 *
 */
@Slf4j
@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.mc.**.ctrl"})
public class McRootWebAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.debug("设置上下文根");
		return new Class[]{McRootWebAnnotationConfigDispatcherServletInitializer.class,McDAOContextConfiguration.class,McServiceContextConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.debug("设置servlet上下文根");
		return new Class[]{McRootWebAnnotationConfigDispatcherServletInitializer.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
