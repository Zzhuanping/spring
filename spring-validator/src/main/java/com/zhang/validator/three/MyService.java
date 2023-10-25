package com.zhang.validator.three;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class MyService {

    public String testMethod(@NotNull @Valid User user){//给参数打上不为空和校验的注解

        return user.getName();
    }
}
