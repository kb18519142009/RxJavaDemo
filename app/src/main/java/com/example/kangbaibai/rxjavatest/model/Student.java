package com.example.kangbaibai.rxjavatest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
