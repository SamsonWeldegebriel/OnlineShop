package com.samson.onlineshop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DatabaseConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{WebApplicationContextConfig.class};
    }

    protected String[] getServletMappings() {

        return new String[]{"/"};
    }
}
