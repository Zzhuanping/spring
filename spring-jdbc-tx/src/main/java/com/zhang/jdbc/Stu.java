package com.zhang.jdbc;

public class Stu {
    private String user_name;
    private int user_pw;
    private String user_address;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(int user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "user_name='" + user_name + '\'' +
                ", user_pw=" + user_pw +
                ", user_address='" + user_address + '\'' +
                '}';
    }

}
