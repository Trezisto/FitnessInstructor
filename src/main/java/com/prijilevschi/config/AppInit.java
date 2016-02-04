package com.prijilevschi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * {@inheritDoc}
     * This method must contain configurations which initalize beans. For beans init we use @Bean annotation
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
            AppConfig.class
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
        	AppConfig.class
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}

