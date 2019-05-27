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
import com.tongu.rbac.model.bo.GrantMenuBO;
import com.tongu.rbac.model.entity.RoleEntity;
import com.tongu.rbac.service.RoleService;

/**   
 * 角色管理
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月18日 上午9:50:07 $ 
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
	public String list(Model model) {	
		return "/role/list";
	}
	
	@RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
	public String detail(Model model) {
		return "/role/detail";
	}
	
	@RequestMapping(value = {"/grant"}, method = RequestMethod.GET)
	public String grant(Model model) {
		return "/role/grant";
	}
	
	/**
	 * 查询所的角色
	 * @param params
	 * @return ResultVo
	 */
	@GetMapping(value="/query")
	public @ResponseBody RespData<Page<RoleEntity>> queryAll(RoleEntity entity, @PageableDefault(sort = { "createDate" }, direction = Sort.Direction.DESC)Pageable page){
		return success(roleService.queryAll(entity, page));
	}
	
	@PostMapping("/save")
	public @ResponseBody RespData<Object> saveRole(@RequestBody RoleEntity entity){
		entity.setBasicModelProperty(getUser().getId(), Objects.isNull(entity.getId()) ? true : false);
		roleService.saveRole(entity);
		return success();
	}
	
	@GetMapping(value="/query/{id}")
	public @ResponseBody RespData<RoleEntity> queryById(@PathVariable("id")String id) {
		return success(roleService.queryById(id));
	}
	
	@PostMapping("/delete")
	public @ResponseBody RespData<Object> deleteRole(@RequestBody Set<String> ids){
		roleService.deleteRole(ids);
		return success();
	}
	
	@PostMapping("/grant/menus")
	public @ResponseBody RespData<Object> grantMenus(@RequestBody GrantMenuBO grantMenu){
		grantMenu.setUpdateUserId(getUser().getId());
		roleService.grantRole(grantMenu);
		return success();
	}
	
	@PostMapping("/query/by/user/{userId}")
	public @ResponseBody List<RoleEntity> queryByUserId(@PathVariable("userId")String userId){
		return roleService.queryByUserId(userId);
	}
}
