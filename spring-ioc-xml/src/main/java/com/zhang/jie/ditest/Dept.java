package com.zhang.jie.ditest;

import java.util.List;

public class Dept {
    private String dname;

    private List<emp> emplist;

    public String getDname() {
        return dname;
    }

    public List<emp> getEmplist() {
        return emplist;
    }

    public void setEmplist(List<emp> emplist) {
        this.emplist = emplist;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void info(){
        System.out.println("部门名称 "+dname);
        for (emp emp : emplist) {
            System.out.println("岗位是 "+emp.getName());

        }

    }


}
