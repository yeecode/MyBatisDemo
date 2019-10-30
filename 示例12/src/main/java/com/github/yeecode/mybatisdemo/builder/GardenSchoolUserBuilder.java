package com.github.yeecode.mybatisdemo.builder;

import com.github.yeecode.mybatisdemo.model.User;

public class GardenSchoolUserBuilder implements UserBuilder {
    private String name;
    private String email;
    private Integer age;
    private Integer sex;
    private String schoolName;

    public GardenSchoolUserBuilder(String name) {
        this.name = name;
    }

    public GardenSchoolUserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public GardenSchoolUserBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public GardenSchoolUserBuilder setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public User build() {
        if (this.email == null) {
            this.email = this.name.toLowerCase().replace(" ", "").concat("@gardenschool.com");
        }
        if (this.age == null) {
            this.age = 13;
        }
        if (this.sex == null) {
            this.sex = 0;
        }
        this.schoolName = "Garden School";
        return new User(name, email, age, sex, schoolName);
    }

}
