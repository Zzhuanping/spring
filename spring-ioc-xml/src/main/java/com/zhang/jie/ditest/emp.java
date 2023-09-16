package com.zhang.jie.ditest;

import java.util.Arrays;

public class emp {

    private Dept dept;
//    该员工属于某个部门
    private String name;

    private String[] loves;

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public Dept getDept() {
        return dept;
    }

    public String[] getLoves() {
        return loves;
    }

    public void work(){
        System.out.println("i am "+name+"   working "+age);
        dept.info();

        System.out.println(name+"的爱好是： "+Arrays.toString(loves)); // 输出数组全部值
    }

    public String getName() {
        return name;
    }
}
