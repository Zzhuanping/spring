package com.zhang.jie.lifecycle;

public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void initme(){
        System.out.println("4 调用指定方法用于初始化");

    }

        public void destm(){

            System.out.println("7 bean调用指定方法用于销毁");
    }

    public void setName(String name) {
        this.name = name;

        System.out.println("2 给bean对象设置属性值");
    }

    public User() {
        System.out.println("1 调用无参数构造 创建bean对象");
    }


}
