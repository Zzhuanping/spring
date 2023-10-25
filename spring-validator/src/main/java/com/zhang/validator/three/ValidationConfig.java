package com.zhang.validator.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan("com.zhang.validator.three")
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor meth(){ //方法来实现校验

        return new MethodValidationPostProcessor();

    }
}
