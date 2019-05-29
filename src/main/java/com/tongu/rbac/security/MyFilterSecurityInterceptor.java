package com.tongu.rbac.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

	@Autowired
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	private List<AntPathRequestMatcher> prefixIignores = null;

	@Autowired
	public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
		super.setAccessDecisionManager(myAccessDecisionManager);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(prefixIignores == null) {
			prefixIignores = Lists.newArrayList();
			for(String s : new String[] {"/css/**", "/js/**", "/html/**", "/img/**"}) {
				prefixIignores.add(new AntPathRequestMatcher(s));
			}
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		if(canIgnore(fi)) {
			try {
				fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
				return;
			} catch (Exception e) {
			}
		}
		
		// fi里面有一个被拦截的url
		// 里面调用MyInvocationSecurityMetadataSource的getAttributes(Object
		// object)这个方法获取fi对应的所有权限
		// 再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			// 执行下一个拦截器
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	private boolean canIgnore(FilterInvocation fi) {  
        for (AntPathRequestMatcher matcher : prefixIignores) {  
            if (matcher.matches(fi.getHttpRequest())) {  
                return true;  
            }
        }  
        return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}

}
