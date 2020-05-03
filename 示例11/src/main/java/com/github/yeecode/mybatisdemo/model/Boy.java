package com.github.yeecode.mybatisdemo.model;

public class Boy extends User {
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return super.toString() +"\n"
                +"Boy{" +
                "age='" + age + '\'' +
                '}';
    }
}
