package com.github.yeecode.mybatisdemo.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer sex;
    private String schoolName;

    public User() {
    }

    public User(Integer id, String name, Integer sex, String schoolName) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
