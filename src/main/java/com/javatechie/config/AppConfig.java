package com.javatechie.config;

import com.javatechie.service.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductServiceImpl productService() {
        return new ProductServiceImpl();
    }



    // other beans and configuration methods
}

