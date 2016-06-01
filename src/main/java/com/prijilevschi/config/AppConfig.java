package com.prijilevschi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Main configuration class for running web-application.
 * 
 * @author Evgheni Prijilevschi
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "com.prijilevschi.*" })
@Import({ PersistenceJPAConfig.class, SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/images/exercise/**").addResourceLocations("/images/exercise/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
	}

	@Bean
    public ServletContextTemplateResolver setupViewResolver(){
	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode("HTML5");

        return templateResolver;
    }

    @Bean
	public SpringTemplateEngine setupTempateEngine(){
	SpringTemplateEngine springTE = new SpringTemplateEngine();
	springTE.setTemplateResolver(setupViewResolver());

	return springTE;
    }

    @Bean
    public ThymeleafViewResolver setupTLViewResolver(){
	ThymeleafViewResolver thymeleafVR = new ThymeleafViewResolver();
	thymeleafVR.setCharacterEncoding("UTF-8");
	thymeleafVR.setTemplateEngine(setupTempateEngine());

	return thymeleafVR;
    }
}
