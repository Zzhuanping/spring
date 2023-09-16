package com.zhang.jie.dimap;

import java.util.List;
import java.util.Map;

public class Student {

    private String sid;
    private  String sname;

    private Map<String,Teacher> teacherMap;


    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void show(){
        System.out.println("名字是： "+sname+"   编号： "+sid);
        System.out.println(" 老师信息 ："+teacherMap+"\n"+lessonList);
    }





    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", teacher=" + teacherMap +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
