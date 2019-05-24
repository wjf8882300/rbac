package com.tongu.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tongu.rbac.service.MenuService;

/**   
 * 首页
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月18日 上午9:55:04 $ 
 */
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private MenuService menuService;

	/**
	 * 跳转到首页
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		//加载菜单
		model.addAttribute("menuList", menuService.queryByUserId(getUser().getId()));
		return "index";
	}
}
