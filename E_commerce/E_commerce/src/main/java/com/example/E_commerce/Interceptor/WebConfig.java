package com.example.E_commerce.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	 @Autowired
	 private AuthenticationInterceptor authenticationInterceptor;

	    public WebConfig(AuthenticationInterceptor authenticationInterceptor) {
	        this.authenticationInterceptor = authenticationInterceptor;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authenticationInterceptor)
	                .addPathPatterns("/cart/**"); // Protect cart endpoints
	    }

}
