
/**
 * 常量
 */
define(function() {
	return {
		
		/**
		 * 公用
		 */
		constants: {
			
		},
		
		/**
		 * 用户管理
		 */
		user: {
			list:"/user/list", //列表页面
			detail:"/user/detail", //详细页面
			queryAll:"/user/query", //列表页面表格数据
			save:"/user/save",
			del:"/user/delete",
			queryById:"/user/query/"
		},
		
		/**
		 * 角色管理
		 */
		role: {
			list:"/role/list",
			detail:"/role/detail",
			queryAll:"/role/query",
			save:"/role/save",
			del:"/role/delete",
			queryById:"/role/query/",
			grant:"/role/grant"			
		},
		
		/**
		 * 菜单管理
		 */
		menu: {
			list:"/menu/list.html",
			detail:"/menu/detail.html",
			queryAll:"/menu/query",
			save:"/menu/save",
			del:"/menu/delete",
			queryById:"/menu/query/",
			queryByRoleId:"/menu/query/by/role/"
		}
	};
});