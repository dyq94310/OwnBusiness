package com.deng.fileupdate.config;

import com.deng.fileupdate.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DengYongQi
 * @date 2019-07-14
 **/
@Configuration
public class ServlectConfig {
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new MyServlet(), "/registerServlet");
    }
}
