package com.fzb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/main/index").setViewName("main/index.html");
        registry.addViewController("/main/user").setViewName("main/user.html");
        registry.addViewController("/main/role").setViewName("main/role.html");
        registry.addViewController("/main/token").setViewName("main/token.html");
        registry.addViewController("/main/product").setViewName("main/product.html");
        registry.addViewController("/main/synData").setViewName("main/synData.html");
        registry.addViewController("/operation/userAdd").setViewName("operation/userAdd.html");
        registry.addViewController("/operation/userUpdate").setViewName("operation/userUpdate.html");
        registry.addViewController("/operation/userGiveRole").setViewName("operation/userGiveRole.html");
    }
}
