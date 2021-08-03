package com.mingdev.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问（授权）
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限的默认跳转至登陆页面,开启登录的页面
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");
        http.logout().deleteCookies("remove").invalidateHttpSession(true).logoutSuccessUrl("/");
        //.logout().deleteCookies("remove").invalidateHttpSession(false)
        //	   				.logoutUrl("/custom-logout").logoutSuccessUrl("/logout-success");
        //	   	}
        //cookie默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }

    //认证
    //密码编码：asswordEncoder mapped for the id "null"
    //在SpringSecurity5.0+ 新增了很多加密方法

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("mingdev").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and().withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and().withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
