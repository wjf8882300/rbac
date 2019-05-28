define(["jquery", "Common", "Constant", "ligerui.ligerGrid"], function($, Common, Constant) {
	
	var grid = null;
	var init = function() {
		/**
		 * 记载列表
		 */
		grid = $("#maingrid4").ligerGrid({
            checkbox: true,
            method: 'get',
	        columns: [
	        { display: '菜单名称', name: 'menuName', id:'menuName'},
	        { display: '菜单标识', name: 'menuFlag', id: 'menuFlag'},
	        { display: '菜单级别', name: 'menuLevel', id: 'menuLevel'},
	        { display: '菜单类型', name: 'menuType', id: 'menuType', 
                render:function(row){
                    if(row.menuType=='01'){
                        return '菜单';
                    } else {
                        return '按钮';
                    }
                } },
	        { display: '菜单地址', name: 'menuUrl', id: 'menuUrl'}, 
	        { display: '是否启用', name: 'isEnabled', id: 'isEnabled', 
                render:function(row){
                    if(row.isEnabled=='0'){
                        return '启用';
                    } else {
                        return '禁用';
                    }
                } 
            },	        
	        ], 
	        url:Constant.menu.queryAll,
	        parms:null,
	        //contentType:"application/json",
	        root:"content",
	        record:"totalElements",
	        rownumbers:false,
	        pageParmName:"page",
	        pagesizeParmName:"size",
	        page:0,
            pageSize:1000,
            pageSizeOptions: [100, 200, 500, 1000],
	        width: '100%',
	        height:'97%',
	        onSuccess:function(data, grid) {
	        	Common.gridCheck.checkedCustomer = [];
	        },
			onCheckAllRow: Common.gridCheck.f_onCheckAllRow,
			tree: {
                columnId: 'menuName',
                idField: 'id',
                parentIDField: 'parentId'
            },
	        onCheckRow: Common.gridCheck.f_onCheckRow,
	        autoCheckChildren:false
	    });
	};
	
	$("#bntAdd").click(function()
	{
	    $.ligerDialog.open({
	        height:585,
	        width: 700,
	        title : '新增菜单',
	        url: Constant.menu.detail, 
	        showMax: false,
	        showToggle: true,
	        showMin: false,
	        isResize: true,
	        slide: false,
	        data: {
	        	name: "add"
	        }
	    });
	}); 

	$("#bntUpdate").click(function()
	{
		if(Common.gridCheck.checkedCustomer.length == 0) {
			Common.warnMsg("编辑时必须至少选中一行");
			return;
		}
		else if(Common.gridCheck.checkedCustomer.length > 1) {
			Common.warnMsg("编辑时不能选中多行");
			return;
		}
		
	    $.ligerDialog.open({
	        height:585,
	        width: 700,
	        title : '编辑菜单',
	        url: Constant.menu.detail, 
	        showMax: false,
	        showToggle: true,
	        showMin: false,
	        isResize: true,
	        slide: false,
	        data: {
	            name: "update",
	            id:Common.gridCheck.checkedCustomer[0]
	        }
	    });
	    
	}); 
				

	$("#bntDelete").click(function()
	{
		if(Common.gridCheck.checkedCustomer.length == 0) {
			Common.warnMsg("删除时必须至少选中一行");
			return;
		}
		
		Common.showMsg("confirm", "您确定删除选中的数据?", function(yes) {
			if(yes) { 
				var delList = [];
				$.each(Common.gridCheck.checkedCustomer, function(i, item)
	            {
					delList.push(item);
	            });
				Common.saveData(Constant.menu.del, delList, function(data){
					Common.successMsg("删除成功");
					Common.gridCheck.checkedCustomer.splice(0, Common.gridCheck.checkedCustomer.length);
					$("#maingrid4").ligerGrid("reload");
				});
			}
		});
	});

	$("#bntSearch").click(function()
	{
		grid.setParm("menuName", $("#menuname").val());
		grid.loadData(grid.url);
	});

	return {
		init:init
	};
});




		