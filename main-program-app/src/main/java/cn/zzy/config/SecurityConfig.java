package cn.zzy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @Author Ziyun Zhou
 * @Date 2023/9/28 11:17
 * @PackageName:cn.zzy.config
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // -- swagger ui忽略
    private static final String[] AUTH_WHITELIST = {
        // -- swagger ui
        "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**",
        // swagger-boostrap-ui
        "/doc.html"};

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(AUTH_WHITELIST); // 忽略swagger ui静态资源
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // <X> 配置请求地址的权限
            .authorizeRequests().antMatchers("/all").permitAll() // 所有用户可访问
            .antMatchers("/admin/**").hasRole("ADMIN") // 需要 ADMIN 角色
            .antMatchers("/normal").access("hasRole('ROLE_NORMAL')") // 需要 NORMAL 角色。
            // 任何请求，访问的用户都需要经过认证
            .anyRequest().authenticated().and()
            // <Y> 设置 Form 表单登录
            .formLogin()
            // .loginPage("/login") // 登录 URL 地址
            .permitAll() // 所有用户可访问
            .and()
            // 配置退出相关
            .logout()
            // .logoutUrl("/logout") // 退出 URL 地址
            .permitAll(); // 所有用户可访问
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
        // <X> 使用内存中的 InMemoryUserDetailsManager
            inMemoryAuthentication()
            // <Y> 不使用 PasswordEncoder 密码编码器
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            // <Z> 配置 admin 用户
            .withUser("admin").password("admin").roles("ADMIN")
            // <Z> 配置 normal 用户
            .and().withUser("normal").password("normal").roles("NORMAL");
    }

}
