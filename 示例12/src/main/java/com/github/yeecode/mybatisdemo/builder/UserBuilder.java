package com.github.yeecode.mybatisdemo.builder;

import com.github.yeecode.mybatisdemo.model.User;

public interface UserBuilder {

    public UserBuilder setEmail(String email);

    public UserBuilder setAge(Integer age);

    public UserBuilder setSex(Integer sex);

    public User build();
}
