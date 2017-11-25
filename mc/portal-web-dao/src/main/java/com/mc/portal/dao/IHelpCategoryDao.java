/**
 * 
 */
package com.mc.portal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mc.portal.vo.HelpCategory;

/**
 * @author HANTY
 *
 */
@Mapper
public interface IHelpCategoryDao {
	
	@Select("SELECT * FROM MYSQL.Help_Category")
	public List<HelpCategory> getHelpCategory();
}
