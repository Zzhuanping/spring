package com.zhang.jie.dimap;

public class Teacher {
     private String tname;
     private String tid;

    public String getTname() {
        return tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tname='" + tname + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
