package com.tongu.rbac.config;

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
        .antMatchers("/**", "/user/**", "/oauth/**", "/actuator/**", "/v2/api-docs").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login/form")
        .failureUrl("/login?error")
        .permitAll()
        .and()
        .sessionManagement()
        .invalidSessionUrl("/login")
        .maximumSessions(1)
        .expiredSessionStrategy(new SessionInformationExpiredStrategyImpl());
    }

	/*忽略静态资源*/
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
