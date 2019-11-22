package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

/**
 * @author vinod.nagulkar
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/images/**")
               .addResourceLocations("/resources/images")
               .setCachePeriod(3600)
               .resourceChain(true)
               .addResolver(new PathResourceResolver());
    }
} 