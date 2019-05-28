package com.tongu.rbac.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.tongu.rbac.security.MyAuthenticationSuccessHandler;
import com.tongu.rbac.security.SessionInformationExpiredStrategyImpl;
import com.tongu.rbac.security.WebUserDetailsService;
import com.tongu.rbac.util.DesUtil;
import com.tongu.rbac.util.HttpUtil;

@Configuration
@EnableWebSecurity
@Order(10)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private WebUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new PasswordEncoder() {

				@Override
				public String encode(CharSequence rawPassword) {
					return passwordEncoder.encode(rawPassword);
				}

				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					String token = (String)HttpUtil.getRequest().getParameter("token");
					return passwordEncoder.matches(DesUtil.strDec((String)rawPassword, token, null, null), encodedPassword);
				}
            });
    }
 
    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin()
		.and().csrf().disable()
        .authorizeRequests()
        .antMatchers("/oauth/**", "/actuator/**", "/v2/api-docs", "/error/**", "/login/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login/form")
        .successHandler(authenticationSuccessHandler)
        .failureUrl("/login?error")
        //.defaultSuccessUrl("/index")
        .permitAll()
        .and()
        .sessionManagement()
        .invalidSessionUrl("/login")
        .maximumSessions(1)
        .expiredSessionStrategy(new SessionInformationExpiredStrategyImpl())
        ;
    }

	/*忽略静态资源*/
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**", "/html/**", "/img/**");
    }
    
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        //配置模板
        templateResolver.setPrefix("classpath:/static/html/");
        templateResolver.setSuffix(".html");
        // 使用HTML的模式，也就是支持HTML5的方式，使用data-th-*的H5写法来写thymeleaf的标签语法
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // 之前在application.properties中看到的缓存配置
        templateResolver.setCacheable(true);
        return templateResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        //模板引擎增加SpringSecurityDialect，让模板能用到sec前缀，获取spring security的内容
        SpringTemplateEngine engine = new SpringTemplateEngine();
        SpringSecurityDialect securityDialect = new SpringSecurityDialect();
        Set<IDialect> dialects = new HashSet<>();
        dialects.add(securityDialect);
        engine.setAdditionalDialects(dialects);
        
        engine.setTemplateResolver(templateResolver());
        //允许在内容中使用spring EL表达式
        engine.setEnableSpringELCompiler(true);
        
        return engine;
    }
    
    //声明ViewResolver
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
