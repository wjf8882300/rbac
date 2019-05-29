define(["jquery", "Common", "Constant", "jquery.validate", "messages_cn", "ligerui.ligerGrid", "ligerui.ligerComboBox"], function($, Common, Constant){
	
    var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
    
    $("#form-wizard").validate({
		rules:{
		},
		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('error');
			$(element).parents('.control-group').addClass('success');
		},
		submitHandler: function(form) { 
            var treeManager = $("#menuTree").ligerGetTreeManager();
            var treeData = treeManager.getChecked();
            console.log(treeData);
            var menuIds = new Array();
            treeData.forEach(function(e) {menuIds.push(e.data.id);})
			Common.saveData(Constant.role.grantMenus, 
					 {grantRoleId:dialog.get("data").id,
				      menuIds: menuIds
					 }, function(data) {
						 Common.successMsg("保存成功");
						 parent.$("#maingrid4").ligerGrid("reload");			     
					     dialog.close();				     
					 });
		}
	});
	
	var tree = null;
	var init = function() {
		tree = $("#menuTree").ligerTree({ 
	        checkbox: true,
	        isExpand: true, 
            slide: false, 
            enabledCompleteCheckbox: false,
            ajaxType: 'get', 
	        url: Constant.menu.queryAll, 
    	    parms:{user:"1", page:0, size:1000}, 
    	    //ajaxContentType:"application/json", 
    	    idField:'id', 
    	    parentIDField: 'parentId',
    	    idFieldName:'id',
    	    textFieldName:'menuName',
    	    onSuccess:function(data) {
    	    	// 取得原先权限
    	    	Common.queryById(Constant.menu.queryByRoleId + dialog.get("data").id, {}, function(data) {
    				var menuList = data.data;
    				//遍历树   				
    				var parm = function (data)
			        {
    					 for(var i = 0; i< menuList.length; i++){
    						 if(data.id == menuList[i].id){
    							 return true;
    						 }
    					 }
			            return false;
			        };
			        tree.selectNode(parm); 
    			});
    	    }
	    });
    };
    
    $("#bntCanel").click(function() {
    	dialog.close();
    });
	
	return {
		init:init
	};
	
});