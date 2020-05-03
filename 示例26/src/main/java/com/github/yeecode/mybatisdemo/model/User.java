package com.github.yeecode.mybatisdemo.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private Integer sex;
    private String schoolName;
    private List<Task> taskList;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        String ans = "user : " + id + "  :  " + name + "\n";
        if (taskList != null) {
            ans += "Tasks: \n";
            for (Task task: taskList) {
                ans += task.getTaskName() + "\n";
            }
        }
        return ans;
    }
}
