/**
 * 
 */
package com.mc.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.portal.api.IDynMenuService;
import com.mc.portal.vo.Menu;

/**
 * @author HANTY
 *
 */

@Service("IDynMenuService")
public class DynMenuService implements IDynMenuService{

	public List<Menu> loadDynMenusByParent(String parentCode) {
		List<Menu> menus = new ArrayList<Menu>();
		Menu m1 = new Menu();
		m1.setName("企业文化");
		menus.add(m1);
		Menu m2 = new Menu();
		m2.setName("品牌故事");
		menus.add(m2);
		return menus;
	}

}
