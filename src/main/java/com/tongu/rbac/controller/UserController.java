package com.tongu.rbac.controller;

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
import com.tongu.rbac.model.bo.GrantRoleBO;
import com.tongu.rbac.model.entity.UserEntity;
import com.tongu.rbac.service.UserService;

/**
 * 用户管理
 * 
 * @author wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月16日 下午2:39:30 $
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
	public String list(Model model) {

		return "user/list";
	}

	@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
	public String detail(Model model) {

		return "user/detail";
	}

	@RequestMapping(value = { "/grant" }, method = RequestMethod.GET)
	public String grant(Model model) {

		return "user/grant";
	}

	@GetMapping("/query")
	public @ResponseBody RespData<Page<UserEntity>> queryAllUser(UserEntity entity,
			@PageableDefault(sort = { "createDate" }, direction = Sort.Direction.DESC) Pageable page) {
		return success(userService.queryAll(entity, page));
	}

	@PostMapping("/save")
	public @ResponseBody RespData<Object> saveUser(@RequestBody UserEntity entity) {
		entity.setBasicModelProperty(getUser().getId(), Objects.isNull(entity.getId()) ? true : false);
		userService.saveUser(entity);
		return success();
	}

	@GetMapping("/query/{id}")
	public @ResponseBody RespData<UserEntity> queryById(@PathVariable("id") String id) {
		return success(userService.queryById(id));
	}

	@PostMapping("/delete")
	public @ResponseBody RespData<Object> deleteUser(@RequestBody Set<String> ids) {
		userService.deleteUser(ids);
		return success();
	}

	@PostMapping("/grant/role")
	public @ResponseBody RespData<Object> grantRole(@RequestBody GrantRoleBO grantRole) {
		grantRole.setUpdateUserId(getUser().getId());
		userService.grantRole(grantRole);
		return success();
	}
}
