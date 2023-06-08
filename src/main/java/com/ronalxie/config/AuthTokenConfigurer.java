package com.ronalxie.config;

import com.ronalxie.filter.AuthTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthTokenConfigurer {

    @Bean
    public FilterRegistrationBean<AuthTokenFilter> filterRegistrationBean(){
        final FilterRegistrationBean<AuthTokenFilter> filterRegistrationBean=new FilterRegistrationBean<>();
        AuthTokenFilter authTokenFilter=new AuthTokenFilter();
        filterRegistrationBean.setFilter(authTokenFilter);
        return filterRegistrationBean;
    }
}
