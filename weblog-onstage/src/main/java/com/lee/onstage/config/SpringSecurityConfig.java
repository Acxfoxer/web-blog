package com.lee.onstage.config;

import com.lee.onstage.security.filter.VerifyCodeFilter;
import com.lee.onstage.security.handler.MyAuthenticationFailureHandler;
import com.lee.onstage.security.handler.MyAuthenticationSuccessHandler;
import com.lee.onstage.security.handler.RestAuthenticationEntryPoint;
import com.lee.onstage.security.handler.RestfulAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 验证码拦截器
     */
    @Resource
    private VerifyCodeFilter verifyCodeFilter;

    /**
     * 登录成功逻辑
     */
    @Resource
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 登录失败逻辑
     */
    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 无权限拦截器
     */
    @Resource
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * 无权访问 JSON 格式的数据
     */
    @Resource
    private RestfulAccessDeniedHandler accessDeniedHandler;

    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        //关闭csrf
        http.csrf().disable()
                // .sessionManagement()// 基于token，所以不需要session
                // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // .and()
                //未登陆时返回 JSON 格式的数据给前端
                .httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                //任何人都能访问这个请求
                .antMatchers("/captcha",
                        "/swagger-resources/**",
                        "/PearAdmin/**",
                        "/component/**",
                        "/admin/**",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v2/**",
                        "/druid/**").permitAll()
                .and()
                .formLogin()
                //登录页面 不设限访问
                .loginPage("/login.html")
                //拦截的请求
                .loginProcessingUrl("/login")
                // 登录成功
                .successHandler(authenticationSuccessHandler)
                // 登录失败
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .rememberMe().rememberMeParameter("rememberme")
                // 防止iframe 造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and();
        // 禁用缓存
        http.headers().cacheControl();
        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(16);
    }
    /**
     * 身份认证接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
