package kr.co.ensmart.frameworkdemo.base.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.ensmart.frameworkdemo.base.controlleradivce.ExceptionResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    	resolvers.add(new ExceptionResolver());
    	//WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
    }

//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//    	resolvers.add(new ExceptionResolver());
//    	//WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
//    }
}
