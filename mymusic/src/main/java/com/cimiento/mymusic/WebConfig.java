package com.cimiento.mymusic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//This is a short cut. For more complex configuration, remove @EnableWebMvc and extend WebMvcConfigurationSupport
//@EnableWebMvc  
@ComponentScan(basePackages = "com.cimiento.web")
public class WebConfig implements WebMvcConfigurer {
	
	
	@Override
    public void addViewControllers( ViewControllerRegistry registry ) {
       // registry.addViewController( "/" ).setViewName( "redirect:/index.html" );
		//registry.addRedirectViewController("/", "index.html");
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
    }
	
	
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", 
            "classpath:/static/", 
            "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
	
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//
//		registry.addResourceHandler("/*.html").addResourceLocations("/");
//
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//		registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/images/favicon.ico");
//	}

}
