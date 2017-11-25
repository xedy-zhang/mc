/**
 * 
 */
package com.mc.portal.cxt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author HANTY
 *
 */
@Configuration
@ComponentScan(basePackages={"com.mc.**.service"})
public class McServiceContextConfiguration {

}
