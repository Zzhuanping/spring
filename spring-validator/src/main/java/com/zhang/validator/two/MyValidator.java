package com.zhang.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class MyValidator {

    @Autowired
    private Validator validator;

    public String judgeRight(User user){
        BindException bindException = new BindException(user,user.getName()); //用注解判断
        validator.validate(user,bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        System.out.println(allErrors);
        if (!bindException.hasErrors()){
            return "pass";
        }
        return "false";



    }
}
