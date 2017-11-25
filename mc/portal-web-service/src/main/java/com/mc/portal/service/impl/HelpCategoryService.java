/**
 * 
 */
package com.mc.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.portal.api.IHelpCategoryService;
import com.mc.portal.dao.IHelpCategoryDao;
import com.mc.portal.vo.HelpCategory;

/**
 * @author HANTY
 *
 */
@Service("IHelpCategoryService")
public class HelpCategoryService implements IHelpCategoryService{

	@Autowired
	private IHelpCategoryDao helpCategoryDao;
	
	public List<HelpCategory> loadAllHelpCategory() {
		return helpCategoryDao.getHelpCategory();
	}

}
