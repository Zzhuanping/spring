package com.zhang.validator.two;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@ComponentScan("com.zhang.validator.two")
@Configuration
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean tell(){

        return new LocalValidatorFactoryBean();
    }

}