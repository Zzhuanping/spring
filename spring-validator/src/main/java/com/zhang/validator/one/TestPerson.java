package com.zhang.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(100);
        person.setName("jack");
//        创建person对应databinder
        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidatorImpl());
        binder.validate();  //开始校验
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult);
    }
}
