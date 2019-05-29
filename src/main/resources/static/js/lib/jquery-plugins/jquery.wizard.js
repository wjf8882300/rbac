/*
 * jQuery wizard plug-in 3.0.5
 *
 *
 * Copyright (c) 2011 Jan Sundman (jan.sundman[at]aland.net)
 *
 * http://www.thecodemine.org
 *
 * Licensed under the MIT licens:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 */

!function(t){t.widget("ui.formwizard",{_init:function(){var i=this,e=this.options.formOptions.success,s=this.options.formOptions.complete,n=this.options.formOptions.beforeSend,o=this.options.formOptions.beforeSubmit,a=this.options.formOptions.beforeSerialize;return this.options.formOptions=t.extend(this.options.formOptions,{success:function(t,s,n){e&&e(t,s,n),(i.options.formOptions&&i.options.formOptions.resetForm||!i.options.formOptions)&&i._reset()},complete:function(t,e){s&&s(t,e),i._enableNavigation()},beforeSubmit:function(t,e,s){if(o){var n=o(t,e,s);return n||i._enableNavigation(),n}},beforeSend:function(t){if(n){var e=n(t);return e||i._enableNavigation(),e}},beforeSerialize:function(t,e){if(a){var s=a(t,e);return s||i._enableNavigation(),s}}}),this.steps=this.element.find(".step").hide(),this.firstStep=this.steps.eq(0).attr("id"),this.activatedSteps=new Array,this.isLastStep=!1,this.previousStep=void 0,this.currentStep=this.steps.eq(0).attr("id"),this.nextButton=this.element.find(this.options.next).click(function(){return i._next()}),this.nextButtonInitinalValue=this.nextButton.val(),this.nextButton.val(this.options.textNext),this.backButton=this.element.find(this.options.back).click(function(){return i._back(),!1}),this.backButtonInitinalValue=this.backButton.val(),this.backButton.val(this.options.textBack),this.options.validationEnabled&&void 0==jQuery().validate?(this.options.validationEnabled=!1,void 0!==window.console&&console.log("%s","validationEnabled option set, but the validation plugin is not included")):this.options.validationEnabled&&this.element.validate(this.options.validationOptions),this.options.formPluginEnabled&&void 0==jQuery().ajaxSubmit&&(this.options.formPluginEnabled=!1,void 0!==window.console&&console.log("%s","formPluginEnabled option set but the form plugin is not included")),1==this.options.disableInputFields&&t(this.steps).find(":input:not('.wizard-ignore')").attr("disabled","disabled"),this.options.historyEnabled&&t(window).bind("hashchange",void 0,function(e){var s=e.getState("_"+t(i.element).attr("id"))||i.firstStep;if(s!==i.currentStep){if(i.options.validationEnabled&&s===i._navigate(i.currentStep)&&!i.element.valid())return i._updateHistory(i.currentStep),i.element.validate().focusInvalid(),!1;s!==i.currentStep&&i._show(s)}}),this.element.addClass("ui-formwizard"),this.element.find(":input").addClass("ui-wizard-content"),this.steps.addClass("ui-formwizard-content"),this.backButton.addClass("ui-formwizard-button ui-wizard-content"),this.nextButton.addClass("ui-formwizard-button ui-wizard-content"),this.options.disableUIStyles||(this.element.addClass("ui-helper-reset ui-widget ui-widget-content ui-helper-reset ui-corner-all"),this.element.find(":input").addClass("ui-helper-reset ui-state-default"),this.steps.addClass("ui-helper-reset ui-corner-all"),this.backButton.addClass("ui-helper-reset ui-state-default"),this.nextButton.addClass("ui-helper-reset ui-state-default")),this._show(void 0),t(this)},_next:function(){if(this.options.validationEnabled&&!this.element.valid())return this.element.validate().focusInvalid(),!1;if(void 0!=this.options.remoteAjax){var i=this.options.remoteAjax[this.currentStep],e=this;if(void 0!==i){var s=i.success,n=i.beforeSend,o=i.complete;return i=t.extend({},i,{success:function(t,i){(void 0!==s&&s(t,i)||void 0==s)&&e._continueToNextStep()},beforeSend:function(i){e._disableNavigation(),void 0!==n&&n(i),t(e.element).trigger("before_remote_ajax",{currentStep:e.currentStep})},complete:function(i,s){void 0!==o&&o(i,s),t(e.element).trigger("after_remote_ajax",{currentStep:e.currentStep}),e._enableNavigation()}}),this.element.ajaxSubmit(i),!1}}return this._continueToNextStep()},_back:function(){return this.activatedSteps.length>0&&(this.options.historyEnabled?this._updateHistory(this.activatedSteps[this.activatedSteps.length-2]):this._show(this.activatedSteps[this.activatedSteps.length-2],!0)),!1},_continueToNextStep:function(){if(this.isLastStep){for(var t=0;t<this.activatedSteps.length;t++)this.steps.filter("#"+this.activatedSteps[t]).find(":input").not(".wizard-ignore").removeAttr("disabled");return!this.options.formPluginEnabled||(this._disableNavigation(),this.element.ajaxSubmit(this.options.formOptions),!1)}var i=this._navigate(this.currentStep);return i!=this.currentStep&&(this.options.historyEnabled?this._updateHistory(i):this._show(i,!0),!1)},_updateHistory:function(i){var e={};e["_"+t(this.element).attr("id")]=i,t.bbq.pushState(e)},_disableNavigation:function(){this.nextButton.attr("disabled","disabled"),this.backButton.attr("disabled","disabled"),this.options.disableUIStyles||(this.nextButton.removeClass("ui-state-active").addClass("ui-state-disabled"),this.backButton.removeClass("ui-state-active").addClass("ui-state-disabled"))},_enableNavigation:function(){this.isLastStep?this.nextButton.val(this.options.textSubmit):this.nextButton.val(this.options.textNext),t.trim(this.currentStep)!==this.steps.eq(0).attr("id")&&(this.backButton.removeAttr("disabled"),this.options.disableUIStyles||this.backButton.removeClass("ui-state-disabled").addClass("ui-state-active")),this.nextButton.removeAttr("disabled"),this.options.disableUIStyles||this.nextButton.removeClass("ui-state-disabled").addClass("ui-state-active")},_animate:function(t,i,e){this._disableNavigation();var s=this.steps.filter("#"+t),n=this.steps.filter("#"+i);s.find(":input").not(".wizard-ignore").attr("disabled","disabled"),n.find(":input").not(".wizard-ignore").removeAttr("disabled");var o=this;s.animate(o.options.outAnimation,o.options.outDuration,o.options.easing,function(){n.animate(o.options.inAnimation,o.options.inDuration,o.options.easing,function(){o.options.focusFirstInput&&n.find(":input:first").focus(),o._enableNavigation(),e.apply(o)})})},_checkIflastStep:function(i){this.isLastStep=!1,(t("#"+i).hasClass(this.options.submitStepClass)||this.steps.filter(":last").attr("id")==i)&&(this.isLastStep=!0)},_getLink:function(i){var e=void 0,s=this.steps.filter("#"+i).find(this.options.linkClass);return void 0!=s&&(e=s.filter(":radio,:checkbox").size()>0?s.filter(this.options.linkClass+":checked").val():t(s).val()),e},_navigate:function(t){var i=this._getLink(t);if(void 0!=i)return""!=i&&null!=i&&void 0!=i&&void 0!=this.steps.filter("#"+i).attr("id")?i:this.currentStep;if(void 0==i&&!this.isLastStep){return this.steps.filter("#"+t).next().attr("id")}},_show:function(i){var e=!1,s=void 0!==i;if(void 0==i||""==i?(this.activatedSteps.pop(),i=this.firstStep,this.activatedSteps.push(i)):t.inArray(i,this.activatedSteps)>-1?(e=!0,this.activatedSteps.pop()):this.activatedSteps.push(i),this.currentStep!==i||i===this.firstStep){this.previousStep=this.currentStep,this._checkIflastStep(i),this.currentStep=i;var n=function(){s&&t(this.element).trigger("step_shown",t.extend({isBackNavigation:e},this._state()))};this._animate(this.previousStep,i,n)}},_reset:function(){this.element.resetForm(),t("label,:input,textarea",this).removeClass("error");for(var i=0;i<this.activatedSteps.length;i++)this.steps.filter("#"+this.activatedSteps[i]).hide().find(":input").attr("disabled","disabled");this.activatedSteps=new Array,this.previousStep=void 0,this.isLastStep=!1,this.options.historyEnabled?this._updateHistory(this.firstStep):this._show(this.firstStep)},_state:function(t){var i={settings:this.options,activatedSteps:this.activatedSteps,isLastStep:this.isLastStep,isFirstStep:this.currentStep===this.firstStep,previousStep:this.previousStep,currentStep:this.currentStep,backButton:this.backButton,nextButton:this.nextButton,steps:this.steps,firstStep:this.firstStep};return void 0!==t?i[t]:i},show:function(t){this.options.historyEnabled?this._updateHistory(t):this._show(t)},state:function(t){return this._state(t)},reset:function(){this._reset()},next:function(){this._next()},back:function(){this._back()},destroy:function(){this.element.find("*").removeAttr("disabled").show(),this.nextButton.unbind("click").val(this.nextButtonInitinalValue).removeClass("ui-state-disabled").addClass("ui-state-active"),this.backButton.unbind("click").val(this.backButtonInitinalValue).removeClass("ui-state-disabled").addClass("ui-state-active"),this.backButtonInitinalValue=void 0,this.nextButtonInitinalValue=void 0,this.activatedSteps=void 0,this.previousStep=void 0,this.currentStep=void 0,this.isLastStep=void 0,this.options=void 0,this.nextButton=void 0,this.backButton=void 0,this.formwizard=void 0,this.element=void 0,this.steps=void 0,this.firstStep=void 0},update_steps:function(){this.steps=this.element.find(".step").addClass("ui-formwizard-content"),this.steps.not("#"+this.currentStep).hide().find(":input").addClass("ui-wizard-content").attr("disabled","disabled"),this._checkIflastStep(this.currentStep),this._enableNavigation(),this.options.disableUIStyles||(this.steps.addClass("ui-helper-reset ui-corner-all"),this.steps.find(":input").addClass("ui-helper-reset ui-state-default"))},options:{historyEnabled:!1,validationEnabled:!1,validationOptions:void 0,formPluginEnabled:!1,linkClass:".link",submitStepClass:"submit_step",back:":reset",next:":submit",textSubmit:"Submit",textNext:"Next",textBack:"Back",remoteAjax:void 0,inAnimation:{opacity:"show"},outAnimation:{opacity:"hide"},inDuration:400,outDuration:400,easing:"swing",focusFirstInput:!1,disableInputFields:!0,formOptions:{reset:!0,success:function(t){void 0!==window.console&&console.log("%s","form submit successful")},disableUIStyles:!1}}})}(jQuery);