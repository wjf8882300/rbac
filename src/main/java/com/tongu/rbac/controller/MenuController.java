package com.tongu.rbac.controller;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tongu.rbac.model.RespData;
import com.tongu.rbac.model.entity.MenuEntity;
import com.tongu.rbac.service.MenuService;

/**   
 * 菜单
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月18日 上午9:50:07 $ 
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
	public String list(Model model) {
	
		return "/menu/list";
	}
	
	@RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
	public String detail(Model model) {
	
		return "/menu/detail";
	}
	
	@GetMapping("/query/by/user/{userId}")
	public @ResponseBody RespData<List<MenuEntity>> queryByUserId(@PathVariable("userId") String userId) {
		return success(menuService.queryByUserId(userId));
	}
	
	@GetMapping("/query/by/role/{roleId}")
	public @ResponseBody RespData<List<MenuEntity>> queryByRoleId(@PathVariable("roleId") String roleId) {
		return success(menuService.queryByRoleId(roleId));
	}
	
	@PostMapping("/save")
	public @ResponseBody RespData<Object> saveMenu(@RequestBody MenuEntity menu){
		menu.setBasicModelProperty(getUser().getId(), Objects.isNull(menu.getId()) ? true : false);
		menuService.saveMenu(menu);
		return success();
	}
	
	@GetMapping("/query/{id}")
	public @ResponseBody RespData<MenuEntity> queryById(@PathVariable("id")String id) {
		return success(menuService.queryById(id));
	}
	
	@PostMapping("/delete")
	public @ResponseBody RespData<Object> deleteMenu(@RequestBody Set<String> ids){
		menuService.deleteMenu(ids);
		return success();
	}
	
	@GetMapping("/query")
	public @ResponseBody RespData<Page<MenuEntity>> queryAll(MenuEntity entity, @PageableDefault(sort = { "createDate" }, direction = Sort.Direction.DESC)Pageable page){
		return success(menuService.queryAll(entity, page));
	}
	
}	
