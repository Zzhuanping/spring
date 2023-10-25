package com.zhang.validator.two;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class User {

    @Range(min = 0,max = 100,message = "out of brands")
    private int age;

    @NotBlank
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
