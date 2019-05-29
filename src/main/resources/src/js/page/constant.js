
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
            // 静态页面
			list:"/user/list", //列表页面
			detail:"/user/detail", //详细页面
            grant: "/user/grant", // 分配角色页面
            
            // 数据接口
			queryAll:"/user/query", //列表页面表格数据
			save:"/user/save",
			del:"/user/delete",
			queryById:"/user/query/",
			grantRoles:"/user/grant/role"
		},
		
		/**
		 * 角色管理
		 */
		role: {
            // 静态页面
			list:"/role/list",
            detail:"/role/detail",
            grant:"/role/grant",

            // 数据接口
			queryAll:"/role/query",
			save:"/role/save",
			del:"/role/delete",
			queryById:"/role/query/",
			grantMenus:"/role/grant/menus",
			queryByUserId:"/role/query/by/user/"
		},
		
		/**
		 * 菜单管理
		 */
		menu: {
            // 静态页面
			list:"/menu/list",
            detail:"/menu/detail",
            
            // 数据接口
			queryAll:"/menu/query",
			save:"/menu/save",
			del:"/menu/delete",
			queryById:"/menu/query/",
			queryByRoleId:"/menu/query/by/role/"
		}
	};
});