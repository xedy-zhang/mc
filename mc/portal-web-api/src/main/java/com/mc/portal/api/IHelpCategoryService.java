/**
 * 
 */
package com.mc.portal.api;

import java.util.List;

import com.mc.portal.vo.HelpCategory;

/**
 * @author HANTY
 *
 */
public interface IHelpCategoryService {
	public List<HelpCategory> loadAllHelpCategory();
}