package peaksoft.crudlms_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import peaksoft.crudlms_security.service.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("USER","CREATOR","EDITOR","ADMIN")
                .antMatchers("/company/new_company").hasAnyAuthority("ADMIN","CREATOR")
                .antMatchers("/course/new_course").hasAnyAuthority("ADMIN","CREATOR")
                .antMatchers("/group/new_group").hasAnyAuthority("ADMIN","CREATOR")
                .antMatchers("/student/new_student").hasAnyAuthority("ADMIN","CREATOR")
                .antMatchers("/teacher/new_teacher").hasAnyAuthority("ADMIN","CREATOR")
                .antMatchers("/company/edit/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR")
                .antMatchers("/course/edit/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR")
                .antMatchers("/student/edit/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR")
                .antMatchers("/teacher/edit/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR")
                .antMatchers("/group/edit/**").hasAnyAuthority("ADMIN","CREATOR","EDITOR")
                .antMatchers("/company/delete/**").hasAnyAuthority("ADMIN")
                .antMatchers("/student/delete/**").hasAnyAuthority("ADMIN")
                .antMatchers("/teacher/delete/**").hasAnyAuthority("ADMIN")
                .antMatchers("/group/delete/**").hasAnyAuthority("ADMIN")
                .antMatchers("/course/delete/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
