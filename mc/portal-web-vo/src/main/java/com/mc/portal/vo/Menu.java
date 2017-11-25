/**
 * 
 */
package com.mc.portal.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author HANTY
 *
 */
@Data
public class Menu implements Serializable{
	String name;
	String path;
	String imgPath;
	int order;
	List<Menu> menus;
}
