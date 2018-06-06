package com.example.kangbaibai.rxjavatest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class Course {
    private String name;
    private List<String> content = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
