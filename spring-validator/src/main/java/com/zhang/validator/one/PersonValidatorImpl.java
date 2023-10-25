package com.zhang.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PersonValidatorImpl implements Validator {

    @Override
    public boolean supports(Class<?> aClass) { //需要对哪一个实体类校验
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) { //校验规则
//        name属性不能为空
        ValidationUtils.rejectIfEmpty(errors,"name","name.emplty","name is null ");  //判断哪一个字段为空，为空时的错误提示信息

        Person p = (Person)o; //转换实体类对象类型
        if (p.getAge()<0){
            errors.rejectValue("age","age.error","too small");
        }else if (p.getAge()>200){
            errors.rejectValue("age","age.error","too old");
        }

    }
}
