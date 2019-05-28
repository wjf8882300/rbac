package com.tongu.rbac.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController extends BasicErrorController{

	public CustomErrorController(ServerProperties serverProperties) {
		super(new DefaultErrorAttributes(), serverProperties.getError());
	}
	
    /**
     * 覆盖默认的Json响应
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);

        //输出自定义的Json格式
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 500);
        map.put("msg", body.get("message"));

        return new ResponseEntity<Map<String, Object>>(map, status);
    }

    /**
     * 覆盖默认的HTML响应
     */
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        //请求的状态
        HttpStatus status = getStatus(request);
        response.setStatus(getStatus(request).value());

        Map<String, Object> model = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML));
        
        Exception exception = (Exception) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if(exception instanceof AuthenticationException) {
        	status = HttpStatus.FORBIDDEN;
        }

        switch(status) {
        case FORBIDDEN:
        	return new ModelAndView("/error/error403", model);
        case NOT_FOUND:
        	return new ModelAndView("/error/error404", model); 	
        case METHOD_NOT_ALLOWED:
        	return new ModelAndView("/error/error405", model); 	
        default:
        	return new ModelAndView("/error/error500", model);
        }
    }
}
