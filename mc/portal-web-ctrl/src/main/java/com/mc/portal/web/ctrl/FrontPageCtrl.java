/**
 * 
 */
package com.mc.portal.web.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.portal.api.IDynMenuService;
import com.mc.portal.api.IHelpCategoryService;
import com.mc.portal.vo.Menu;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HANTY
 *
 */
@RestController
@Slf4j
public class FrontPageCtrl {
	
	@Resource(name="IDynMenuService")
	IDynMenuService menuService;
	
	@RequestMapping("/dynmenus")
	public Object getDynamicMenus(HttpServletRequest request,HttpServletResponse response){
		log.debug("日志测试，进入动态菜单action。。。");
		Menu menu = new Menu();
		menu.setName("图片名称");
		List<Menu> menus = new ArrayList<Menu>();
		menus.add(new Menu());
		menus.add(new Menu());
		menu.setMenus(menus);
		log.debug("调用IDynMenuService服务开始");
		List<Menu> menusInDB = menuService.loadDynMenusByParent("00001");
		log.info("根据{}从数据库加载动态菜单数量：{}","00001",menusInDB.size());
		menu.getMenus().get(0).setMenus(menusInDB);
		log.debug("调用IDynMenuService服务结束");
		return menu;
	}
	
	@Resource(name="IHelpCategoryService")
	private IHelpCategoryService helpCategoryService;
	
	@RequestMapping("/help")
	public Object getHelpCategoryService(){
		return helpCategoryService.loadAllHelpCategory();
	}
}