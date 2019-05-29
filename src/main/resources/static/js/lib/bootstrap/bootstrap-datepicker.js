/* =========================================================
 * bootstrap-datepicker.js 
 * http://www.eyecon.ro/bootstrap-datepicker
 * =========================================================
 * Copyright 2012 Stefan Petre
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */

!function(t){var e=function(e,a){if(this.element=t(e),this.format=s.parseFormat(a.format||this.element.data("date-format")||"mm/dd/yyyy"),this.picker=t(s.template).appendTo("body").on({click:t.proxy(this.click,this),mousedown:t.proxy(this.mousedown,this)}),this.isInput=this.element.is("input"),this.component=!!this.element.is(".date")&&this.element.find(".add-on"),this.isInput?this.element.on({focus:t.proxy(this.show,this),blur:t.proxy(this.hide,this),keyup:t.proxy(this.update,this)}):this.component?this.component.on("click",t.proxy(this.show,this)):this.element.on("click",t.proxy(this.show,this)),this.minViewMode=a.minViewMode||this.element.data("date-minviewmode")||0,"string"==typeof this.minViewMode)switch(this.minViewMode){case"months":this.minViewMode=1;break;case"years":this.minViewMode=2;break;default:this.minViewMode=0}if(this.viewMode=a.viewMode||this.element.data("date-viewmode")||0,"string"==typeof this.viewMode)switch(this.viewMode){case"months":this.viewMode=1;break;case"years":this.viewMode=2;break;default:this.viewMode=0}this.startViewMode=this.viewMode,this.weekStart=a.weekStart||this.element.data("date-weekstart")||0,this.weekEnd=0===this.weekStart?6:this.weekStart-1,this.fillDow(),this.fillMonths(),this.update(),this.showMode()};e.prototype={constructor:e,show:function(e){this.picker.show(),this.height=this.component?this.component.outerHeight():this.element.outerHeight(),this.place(),t(window).on("resize",t.proxy(this.place,this)),e&&(e.stopPropagation(),e.preventDefault()),this.isInput||t(document).on("mousedown",t.proxy(this.hide,this)),this.element.trigger({type:"show",date:this.date})},hide:function(){this.picker.hide(),t(window).off("resize",this.place),this.viewMode=this.startViewMode,this.showMode(),this.isInput||t(document).off("mousedown",this.hide),this.set(),this.element.trigger({type:"hide",date:this.date})},set:function(){var t=s.formatDate(this.date,this.format);this.isInput?this.element.prop("value",t):(this.component&&this.element.find("input").prop("value",t),this.element.data("date",t))},setValue:function(t){this.date="string"==typeof t?s.parseDate(t,this.format):new Date(t),this.set(),this.viewDate=new Date(this.date.getFullYear(),this.date.getMonth(),1,0,0,0,0),this.fill()},place:function(){var t=this.component?this.component.offset():this.element.offset();this.picker.css({top:t.top+this.height,left:t.left})},update:function(t){this.date=s.parseDate("string"==typeof t?t:this.isInput?this.element.prop("value"):this.element.data("date"),this.format),this.viewDate=new Date(this.date.getFullYear(),this.date.getMonth(),1,0,0,0,0),this.fill()},fillDow:function(){for(var t=this.weekStart,e="<tr>";t<this.weekStart+7;)e+='<th class="dow">'+s.dates.daysMin[t++%7]+"</th>";e+="</tr>",this.picker.find(".datepicker-days thead").append(e)},fillMonths:function(){for(var t="",e=0;e<12;)t+='<span class="month">'+s.dates.monthsShort[e++]+"</span>";this.picker.find(".datepicker-months td").append(t)},fill:function(){var t=new Date(this.viewDate),e=t.getFullYear(),a=t.getMonth(),i=this.date.valueOf();this.picker.find(".datepicker-days th:eq(1)").text(s.dates.months[a]+" "+e);var n=new Date(e,a-1,28,0,0,0,0),h=s.getDaysInMonth(n.getFullYear(),n.getMonth());n.setDate(h),n.setDate(h-(n.getDay()-this.weekStart+7)%7);var o=new Date(n);o.setDate(o.getDate()+42),o=o.valueOf(),html=[];for(var d;n.valueOf()<o;)n.getDay()===this.weekStart&&html.push("<tr>"),d="",n.getMonth()<a?d+=" old":n.getMonth()>a&&(d+=" new"),n.valueOf()===i&&(d+=" active"),html.push('<td class="day'+d+'">'+n.getDate()+"</td>"),n.getDay()===this.weekEnd&&html.push("</tr>"),n.setDate(n.getDate()+1);this.picker.find(".datepicker-days tbody").empty().append(html.join(""));var r=this.date.getFullYear(),l=this.picker.find(".datepicker-months").find("th:eq(1)").text(e).end().find("span").removeClass("active");r===e&&l.eq(this.date.getMonth()).addClass("active"),html="",e=10*parseInt(e/10,10);var p=this.picker.find(".datepicker-years").find("th:eq(1)").text(e+"-"+(e+9)).end().find("td");e-=1;for(var c=-1;c<11;c++)html+='<span class="year'+(-1===c||10===c?" old":"")+(r===e?" active":"")+'">'+e+"</span>",e+=1;p.html(html)},click:function(e){e.stopPropagation(),e.preventDefault();var a=t(e.target).closest("span, td, th");if(1===a.length)switch(a[0].nodeName.toLowerCase()){case"th":switch(a[0].className){case"switch":this.showMode(1);break;case"prev":case"next":this.viewDate["set"+s.modes[this.viewMode].navFnc].call(this.viewDate,this.viewDate["get"+s.modes[this.viewMode].navFnc].call(this.viewDate)+s.modes[this.viewMode].navStep*("prev"===a[0].className?-1:1)),this.fill(),this.set()}break;case"span":if(a.is(".month")){var i=a.parent().find("span").index(a);this.viewDate.setMonth(i)}else{var n=parseInt(a.text(),10)||0;this.viewDate.setFullYear(n)}0!==this.viewMode&&(this.date=new Date(this.viewDate),this.element.trigger({type:"changeDate",date:this.date,viewMode:s.modes[this.viewMode].clsName})),this.showMode(-1),this.fill(),this.set();break;case"td":if(a.is(".day")){var h=parseInt(a.text(),10)||1,i=this.viewDate.getMonth();a.is(".old")?i-=1:a.is(".new")&&(i+=1);var n=this.viewDate.getFullYear();this.date=new Date(n,i,h,0,0,0,0),this.viewDate=new Date(n,i,Math.min(28,h),0,0,0,0),this.fill(),this.set(),this.element.trigger({type:"changeDate",date:this.date,viewMode:s.modes[this.viewMode].clsName})}}},mousedown:function(t){t.stopPropagation(),t.preventDefault()},showMode:function(t){t&&(this.viewMode=Math.max(this.minViewMode,Math.min(2,this.viewMode+t))),this.picker.find(">div").hide().filter(".datepicker-"+s.modes[this.viewMode].clsName).show()}},t.fn.datepicker=function(s,a){return this.each(function(){var i=t(this),n=i.data("datepicker"),h="object"==typeof s&&s;n||i.data("datepicker",n=new e(this,t.extend({},t.fn.datepicker.defaults,h))),"string"==typeof s&&n[s](a)})},t.fn.datepicker.defaults={},t.fn.datepicker.Constructor=e;var s={modes:[{clsName:"days",navFnc:"Month",navStep:1},{clsName:"months",navFnc:"FullYear",navStep:1},{clsName:"years",navFnc:"FullYear",navStep:10}],dates:{days:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"],daysShort:["Sun","Mon","Tue","Wed","Thu","Fri","Sat","Sun"],daysMin:["Su","Mo","Tu","We","Th","Fr","Sa","Su"],months:["January","February","March","April","May","June","July","August","September","October","November","December"],monthsShort:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]},isLeapYear:function(t){return t%4==0&&t%100!=0||t%400==0},getDaysInMonth:function(t,e){return[31,s.isLeapYear(t)?29:28,31,30,31,30,31,31,30,31,30,31][e]},parseFormat:function(t){var e=t.match(/[.\/\-\s].*?/),s=t.split(/\W+/);if(!e||!s||0===s.length)throw new Error("Invalid date format.");return{separator:e,parts:s}},parseDate:function(t,e){var s,a=t.split(e.separator),t=new Date;if(t.setHours(0),t.setMinutes(0),t.setSeconds(0),t.setMilliseconds(0),a.length===e.parts.length)for(var i=0,n=e.parts.length;i<n;i++)switch(s=parseInt(a[i],10)||1,e.parts[i]){case"dd":case"d":t.setDate(s);break;case"mm":case"m":t.setMonth(s-1);break;case"yy":t.setFullYear(2e3+s);break;case"yyyy":t.setFullYear(s)}return t},formatDate:function(t,e){var s={d:t.getDate(),m:t.getMonth()+1,yy:t.getFullYear().toString().substring(2),yyyy:t.getFullYear()};s.dd=(s.d<10?"0":"")+s.d,s.mm=(s.m<10?"0":"")+s.m;for(var t=[],a=0,i=e.parts.length;a<i;a++)t.push(s[e.parts[a]]);return t.join(e.separator)},headTemplate:'<thead><tr><th class="prev">&lsaquo;</th><th colspan="5" class="switch"></th><th class="next">&rsaquo;</th></tr></thead>',contTemplate:'<tbody><tr><td colspan="7"></td></tr></tbody>'};s.template='<div class="datepicker dropdown-menu"><div class="datepicker-days"><table class=" table-condensed">'+s.headTemplate+'<tbody></tbody></table></div><div class="datepicker-months"><table class="table-condensed">'+s.headTemplate+s.contTemplate+'</table></div><div class="datepicker-years"><table class="table-condensed">'+s.headTemplate+s.contTemplate+"</table></div></div>"}(window.jQuery);