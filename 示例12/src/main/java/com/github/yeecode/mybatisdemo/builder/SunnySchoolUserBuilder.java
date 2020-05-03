package com.github.yeecode.mybatisdemo.builder;

import com.github.yeecode.mybatisdemo.model.User;

public class SunnySchoolUserBuilder implements UserBuilder {
    private String name;
    private String email;
    private Integer age;
    private Integer sex;
    private String schoolName;

    public SunnySchoolUserBuilder(String name) {
        this.name = name;
    }

    public SunnySchoolUserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public SunnySchoolUserBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public SunnySchoolUserBuilder setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public User build() {
        if (this.name != null && this.email == null) {
            this.email = this.name.toLowerCase().replace(" ", "").concat("@sunnyschool.com");
        }
        if (this.age == null) {
            this.age = 7;
        }
        if (this.sex == null) {
            this.sex = 0;
        }
        this.schoolName = "Sunny School";
        return new User(name, email, age, sex, schoolName);
    }
}
