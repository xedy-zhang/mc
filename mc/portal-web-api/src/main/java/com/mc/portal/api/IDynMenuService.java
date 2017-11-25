/**
 * 
 */
package com.mc.portal.api;

import java.util.List;

import com.mc.portal.vo.Menu;

/**
 * @author HANTY
 *
 */
public interface IDynMenuService {
	
	/**
	 * 使用上级动态菜单代码加载所有子集
	 * @param parentCode 上级代码
	 * @return 所有子集含上级
	 */
	public List<Menu> loadDynMenusByParent(String parentCode);
}
