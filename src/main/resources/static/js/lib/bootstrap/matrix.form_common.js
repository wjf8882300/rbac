$(document).ready(function(){$("input[type=checkbox],input[type=radio],input[type=file]").uniform(),$("select").select2(),$(".colorpicker").colorpicker(),$(".datepicker").datepicker()}),$(document).ready(function(){$("#tags").select2({tags:["red","green","blue","orange"]}),$("textarea").hasClass("elastic")&&$(".elastic").elastic(),$("textarea").hasClass("limit")&&$(".limit").inputlimiter({limit:100}),$("#mask-phone").mask("(999) 999-9999",{completed:function(){alert("Callback action after complete")}}),$("#mask-phoneExt").mask("(999) 999-9999? x99999"),$("#mask-phoneInt").mask("+40 999 999 999"),$("#mask-date").mask("99/99/9999"),$("#mask-ssn").mask("999-99-9999"),$("#mask-productKey").mask("a*-999-a999",{placeholder:"*"}),$("#mask-eyeScript").mask("~9.99 ~9.99 999"),$("#mask-percent").mask("99%"),$(".normal-toggle-button").toggleButtons(),$(".text-toggle-button").toggleButtons({width:140,label:{enabled:"ONLINE",disabled:"OFFLINE"}}),$(".iToggle-button").toggleButtons({width:70,label:{enabled:"<span class='icon16 icomoon-icon-checkmark-2 white'></span>",disabled:"<span class='icon16 icomoon-icon-cancel-3 white marginL5'></span>"}}),$("#spinner1").spinner(),$("#spinner2").spinner({step:.01,numberFormat:"n"}),$("#spinner3").spinner({step:5}),$("#spinner4").spinner({numberFormat:"C"}),$("div").hasClass("picker")&&$(".picker").farbtastic("#color"),$("#datepicker").length&&$("#datepicker").datepicker({showOtherMonths:!0}),$("#datepicker-inline").length&&$("#datepicker-inline").datepicker({inline:!0,showOtherMonths:!0}),$("#combined-picker").length&&$("#combined-picker").datetimepicker(),$("#timepicker").timeEntry({show24Hours:!0,spinnerImage:""}),$("#timepicker").timeEntry("setTime","22:15"),$("#select1").select2(),$("#select2").select2(),$.configureBoxes(),$("textarea.tinymce").tinymce({script_url:"plugins/forms/tiny_mce/tiny_mce.js",theme:"advanced",plugins:"autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,advlist",theme_advanced_buttons1:"save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",theme_advanced_buttons2:"cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",theme_advanced_buttons3:"tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",theme_advanced_buttons4:"insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",theme_advanced_toolbar_location:"top",theme_advanced_toolbar_align:"left",theme_advanced_statusbar_location:"bottom",theme_advanced_resizing:!0,content_css:"css/main.css",template_external_list_url:"lists/template_list.js",external_link_list_url:"lists/link_list.js",external_image_list_url:"lists/image_list.js",media_external_list_url:"lists/media_list.js",template_replace_values:{username:"SuprUser",staffid:"991234"}}),$("#myModal").modal({show:!1}),$("#myModal").on("hidden",function(){console.log("modal is closed")})});var positive=[1,5,3,7,8,6,10],negative=[10,6,8,7,3,5,1],negative1=[7,6,8,7,6,5,4];$("#stat1").sparkline(positive,{height:15,spotRadius:0,barColor:"#9FC569",type:"bar"}),$("#stat2").sparkline(negative,{height:15,spotRadius:0,barColor:"#ED7A53",type:"bar"}),$("#stat3").sparkline(negative1,{height:15,spotRadius:0,barColor:"#ED7A53",type:"bar"}),$("#stat4").sparkline(positive,{height:15,spotRadius:0,barColor:"#9FC569",type:"bar"}),$("#stat5").sparkline(positive,{height:15,spotRadius:0,barColor:"#9FC569",type:"bar"}),$("#stat6").sparkline(positive,{width:70,height:20,lineColor:"#88bbc8",fillColor:"#f2f7f9",spotColor:"#e72828",maxSpotColor:"#005e20",minSpotColor:"#f7941d",spotRadius:3,lineWidth:2});