/**
 * 
 */
require.config({
	
    paths : {
    	'domReady'				: 'https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/domReady',
        "jquery" 				: "lib/jquery/jquery-1.7.2.min",
        "jquery.cookie" 		: "lib/jquery-plugins/jquery.cookie", 
        "jquery.dataTables.min" : "lib/jquery-plugins/jquery.dataTables.min", 
        "jquery.flot.min" 		: "lib/jquery-plugins/jquery.flot.min", 
        "jquery.flot.pie.min" 	: "lib/jquery-plugins/jquery.flot.pie.min", 
        "jquery.flot.resize.min": "lib/jquery-plugins/jquery.flot.resize.min", 
        "jquery.gritter.min" 	: "lib/jquery-plugins/jquery.gritter.min", 
        "jquery.metadata" 		: "lib/jquery-plugins/jquery.metadata", 
        "jquery.peity.min" 		: "lib/jquery-plugins/jquery.peity.min", 
        "jquery.ui.custom" 		: "lib/jquery-plugins/jquery.ui.custom", 
        "jquery.uniform" 		: "lib/jquery-plugins/jquery.uniform", 
        "jquery.validate" 		: "lib/jquery-plugins/jquery.validate", 
        "jquery.wizard" 		: "lib/jquery-plugins/jquery.wizard", 
        "messages_cn" 			: "lib/jquery-plugins/messages_cn", 
        
        "bootstrap.min" 		: "lib/bootstrap/bootstrap.min", 
        "bootstrap-colorpicker" : "lib/bootstrap/bootstrap-colorpicker", 
        "bootstrap-datepicker" 	: "lib/bootstrap/bootstrap-datepicker", 
        "bootstrap-wysihtml5" 	: "lib/bootstrap/bootstrap-wysihtml5", 
        "excanvas.min" 			: "lib/bootstrap/excanvas.min", 
        "fullcalendar.min" 		: "lib/bootstrap/fullcalendar.min", 
        "masked" 				: "lib/bootstrap/masked", 
        "matrix.calendar" 		: "lib/bootstrap/matrix.calendar", 
        "matrix.charts" 		: "lib/bootstrap/matrix.charts", 
        "matrix.chat" 			: "lib/bootstrap/matrix.chat", 
        "matrix.dashboard" 		: "lib/bootstrap/matrix.dashboard", 
        "matrix.form_common" 	: "lib/bootstrap/matrix.form_common", 
        "matrix.form_validation": "lib/bootstrap/matrix.form_validation", 
        "matrix.interface" 		: "lib/bootstrap/matrix.interface", 
        "matrix" 				: "lib/bootstrap/matrix", 
        "matrix.login" 			: "lib/bootstrap/matrix.login",
        "matrix.popover" 		: "lib/bootstrap/matrix.popover",
        "matrix.tables" 		: "lib/bootstrap/matrix.tables",
        "matrix.wizard.js" 		: "lib/bootstrap/matrix.wizard.js",
        "select2.min" 			: "lib/bootstrap/select2.min",
        "wysihtml5-0.3.0" 		: "lib/bootstrap/wysihtml5-0.3.0",
        
        "ligerui.all" 			: "lib/ligerUI/js/ligerui.all", 
        "ligerui.base"			: "lib/ligerUI/js/core/base", 
        "ligerui.inject" 		: "lib/ligerUI/js/core/inject", 
        "ligerui.ligerGrid" 	: "lib/ligerUI/js/plugins/ligerGrid", 
        "ligerui.ligerDialog" 	: "lib/ligerUI/js/plugins/ligerDialog",
        "ligerui.ligerDrag" 	: "lib/ligerUI/js/plugins/ligerDrag",
        "ligerui.ligerResizable": "lib/ligerUI/js/plugins/ligerResizable",
        "ligerui.ligerTab"		: "lib/ligerUI/js/plugins/ligerTab",
        "ligerui.ligerLayout"	: "lib/ligerUI/js/plugins/ligerLayout",
        "ligerui.ligerMenu"	    : "lib/ligerUI/js/plugins/ligerMenu",
        "ligerui.ligerCheckBox"	: "lib/ligerUI/js/plugins/ligerCheckBox",
        "ligerui.ligerTree"		: "lib/ligerUI/js/plugins/ligerTree",
        "ligerui.ligerComboBox"	: "lib/ligerUI/js/plugins/ligerComboBox",
        
        "des" 					: "lib/security/des",
        "json2"					: "lib/json/json2",
        
        "Common"				: "page/common",
        "Constant"				: "page/constant",

        "page/index"            : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/index",
        "page/login"            : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/login",
        "page/user/user"        : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/user/user",
        "page/user/userDetail"  : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/user/userDetail",
        "page/user/userGrant"   : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/user/userGrant",
        "page/role/role"        : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/role/role",
        "page/role/roleDetail"  : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/role/roleDetail",
        "page/role/roleGrant"   : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/role/roleGrant",
        "page/menu/menu"        : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/menu/menu",
        "page/menu/menuDetail"  : "https://tonggu.oss-cn-shanghai.aliyuncs.com/rbac/js/page/menu/menuDetail",
    },
    
    shim: {
        "jquery.cookie" 		: "jquery",
        "jquery.dataTables.min" : "jquery",
        "jquery.flot.min" 		: "jquery",
        "jquery.flot.pie.min" 	: ["jquery", "jquery.flot.min"],
        "jquery.flot.resize.min": ["jquery", "jquery.flot.min"],
        "jquery.gritter.min" 	: "jquery",
        "jquery.metadata" 		: "jquery",
        "jquery.cookie" 		: "jquery",
        "jquery.peity.min" 		: "jquery",
        "jquery.ui.custom" 		: "jquery",
        "jquery.validate" 		: "jquery",
        "jquery.wizard" 		: "jquery",
        "messages_cn" 			: ["jquery", "jquery.validate"],
        
        "des" 					: "jquery",
        "json2"					: "jquery",
        
        "bootstrap.min" 		: "jquery", 
        "bootstrap-colorpicker" : ["jquery", "bootstrap.min"], 
        "bootstrap-datepicker" 	: ["jquery", "bootstrap.min"],
        "bootstrap-wysihtml5" 	: ["jquery", "bootstrap.min"],
        "excanvas.min" 			: "jquery", 
        "fullcalendar.min" 		: "jquery", 
        "masked" 				: "jquery", 
        "matrix.popover" 		: ["jquery", "bootstrap.min"],
        "matrix" 				: ["jquery", "bootstrap.min", "matrix.popover"], 
        "matrix.calendar" 		: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.charts" 		: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.chat" 			: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.dashboard" 		: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.form_common" 	: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.form_validation": ["jquery", "bootstrap.min", "matrix"], 
        "matrix.interface" 		: ["jquery", "bootstrap.min", "matrix"], 
        "matrix.login" 			: ["jquery", "bootstrap.min", "matrix"],        
        "matrix.tables" 		: ["jquery", "bootstrap.min", "matrix"],
        "matrix.wizard.js" 		: ["jquery", "bootstrap.min", "matrix"],
        "select2.min" 			: "jquery",
        "wysihtml5-0.3.0" 		: "jquery",
        
        "ligerui.all" 			: "jquery", 
        "ligerui.base" 			: ["jquery"], 
        "ligerui.inject" 		: ["jquery", "ligerui.base"], 
        "ligerui.ligerResizable": ["jquery", "ligerui.base", "ligerui.inject"],
        "ligerui.ligerDrag" 	: ["jquery", "ligerui.base", "ligerui.inject"],
        "ligerui.ligerCheckBox"	: ["jquery", "ligerui.base", "ligerui.inject"],
        "ligerui.ligerGrid" 	: ["jquery", "ligerui.base", "ligerui.inject", "ligerui.ligerResizable", "ligerui.ligerCheckBox"], 
        "ligerui.ligerDialog" 	: ["jquery", "ligerui.base", "ligerui.inject", "ligerui.ligerResizable", "ligerui.ligerDrag"],        
        "ligerui.ligerTab" 	    : ["jquery", "ligerui.base", "ligerui.inject"],       
        "ligerui.ligerLayout"	: ["jquery", "ligerui.base", "ligerui.inject"],        
        "ligerui.ligerMenu"	    : ["jquery", "ligerui.base", "ligerui.inject"],
        "ligerui.ligerTree"	    : ["jquery", "ligerui.base", "ligerui.inject", "ligerui.ligerResizable"],
        "ligerui.ligerComboBox"	: ["jquery", "ligerui.base", "ligerui.inject", "ligerui.ligerResizable", "ligerui.ligerTree"],
    },
});


// //根据配置加载所需模块
// require(["jquery"], function ($) {
//     $(document).ready(function() {
//         var scripts = document.getElementsByTagName("script");
//         for (var i = 0; i < scripts.length; i++) {
//             // 获取页面所需加载模块入口名称
//             var module = scripts[i].getAttribute("require-module");
//             if (module != undefined && module != "") {
//                 require([ module ], function(Lib) {
//                     Lib.init();
//                 });
//                 break;
//             }
//         }
//     });
// });

require(['domReady!'], function (doc) {
    var scripts = doc.getElementsByTagName("script");
    for (var i = 0; i < scripts.length; i++) {
        // 获取页面所需加载模块入口名称
        var module = scripts[i].getAttribute("require-module");
        if (module != undefined && module != "") {
            require([ module ], function(Lib) {
                Lib.init();
            });
            break;
        }
    }
});

