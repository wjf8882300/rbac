package com.tongu.rbac.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tongu.rbac.model.RespData;

/**   
 * 登录
 *  
 * @author  wangjf
 * @version $Revision:1.0.0, $Date: 2016年5月18日 上午9:50:07 $ 
 */
@Controller
public class LoginController extends BaseController{
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest req, Model model) {
		if(getUser() != null) {
			return "redirect:/index";
		} 
		
		Cookie[] cookies = req.getCookies();
		if(null != cookies && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if("7d418d57421e622343fe607c6b08204e".equals(cookies[i].getName())) {
					//model.addAttribute("mobile", DeEnCodeUtil.decode(cookies[i].getValue()));
					break;
				}
			}
		}
		if(req.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) {
			model.addAttribute("error", "true");
		}
		return "login";
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value="/logfailure", method = RequestMethod.GET)
	public @ResponseBody RespData<String> loginFailure(HttpServletRequest req, Model model) {
		Exception ex = (Exception)req.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		return failure(ex.getMessage());
	}
}
