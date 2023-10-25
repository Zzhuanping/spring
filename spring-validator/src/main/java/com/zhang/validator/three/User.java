package com.zhang.validator.three;

import javax.validation.constraints.*;

public class User {
    @NotNull
    private String name;
    @Max(100)
    @Min(0)
    private int age;
    @Size(min = 1,max = 200,message = "must with")
    @NotBlank(message = "hasn't blank")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
