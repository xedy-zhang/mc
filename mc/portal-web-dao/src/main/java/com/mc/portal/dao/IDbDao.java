/**
 * 
 */
package com.mc.portal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mc.portal.vo.Db;

/**
 * @author HANTY
 *
 */
@Mapper
public interface IDbDao {
	
	@Select("SELECT * FROM MYSQL.DB")
	public List<Db> getDb();
}
