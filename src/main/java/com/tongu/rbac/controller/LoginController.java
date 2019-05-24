package com.tongu.rbac.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tongu.rbac.util.RandomUtil;
import com.tongu.rbac.util.RandomUtil.RandomTypeEnum;

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
		if(req.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) != null) {
			AuthenticationException exception = (AuthenticationException) req.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if(exception instanceof BadCredentialsException) {
				model.addAttribute("error", "用户名或者密码错误");
			} else if(exception instanceof UsernameNotFoundException){
				model.addAttribute("error", "该用户不存在");
			} else {
				model.addAttribute("error", exception.getMessage());
			}
		}
		model.addAttribute("token", RandomUtil.getRandomString(16, RandomTypeEnum.RANDOM_TYPE_OTHER));
		return "login";
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String home(Model model) {
		
		return "login";
	}
}
