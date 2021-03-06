define(["jquery", "Common", "Constant", "ligerui.ligerGrid"], function($, Common, Constant) {
	var grid = null;
	var init = function() {
		grid =$("#maingrid4").ligerGrid({
            checkbox:true,
            method: 'get',
			columns:[
			     { display: '角色名称', name:'roleName'},
			     { display: '是否启用', name:'recordStatus', 
                    render:function(row){
                        if(row.recordStatus=='0'){
                            return '启用';
                        } else {
                            return '禁用';
                        }
                    }
                },
			     { display: '标识',name:'roleKey'},
			     { display:'描述',name:'roleDesc'}
			],
			url:Constant.role.queryAll,
			parms:null,
	        //contentType:"application/json",
	        root:"content",
	        record:"totalElements",
	        rownumbers:false,
	        pageParmName:"page",
	        pagesizeParmName:"size",
	        page:0,
	        pageSize:20,
	        width: '100%',
	        height:'97%',
			onSuccess:function(data,grid){
				Common.gridCheck.checkedCustomer = [];
			},
			onCheckRow: Common.gridCheck.f_onCheckRow, 
			onCheckAllRow: Common.gridCheck.f_onCheckAllRow,
		})
	};
	
	$("#bntAdd").click(function()
	{
	    $.ligerDialog.open({
	        height:398,
	        width: 700,
	        title : '新增角色',
	        url: Constant.role.detail, 
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
	        height:398,
	        width: 700,
	        title : '编辑角色',
	        url: Constant.role.detail, 
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
				Common.saveData(Constant.role.del, delList, function(data){
					Common.successMsg("删除成功");
					Common.gridCheck.checkedCustomer.splice(0, Common.gridCheck.checkedCustomer.length);
					$("#maingrid4").ligerGrid("reload");
				});
			}
		});
	});

	$("#bntSearch").click(function()
	{
		grid.setParm("roleName", $("#username").val());
		grid.loadData(grid.url);
	});
	
	$("#bntPermissions").click(function()
	{
        if(Common.gridCheck.checkedCustomer.length == 0) {
			Common.warnMsg("分配菜单时必须至少选中一行");
			return;
		}
		else if(Common.gridCheck.checkedCustomer.length > 1) {
			Common.warnMsg("分配菜单时不能选中多行");
			return;
		}

	    $.ligerDialog.open({
	        height:398,
	        width: 700,
	        title : '分配权限',
	        url: Constant.role.grant, 
	        showMax: false,
	        showToggle: true,
	        showMin: false,
	        isResize: true,
	        slide: false,
	        data: {
	        	name: "grant",
	        	id:Common.gridCheck.checkedCustomer[0]
	        }
	    });
	});

	return {
		init:init
	};
	
 
});

