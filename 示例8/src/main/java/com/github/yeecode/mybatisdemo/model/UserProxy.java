package com.github.yeecode.mybatisdemo.model;

public class UserProxy implements UserInterface {
    private UserInterface target;

    public UserProxy(UserInterface target) {
        this.target = target;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("pre words");
        target.sayHello(name);
        System.out.println("post words");
        return name;
    }
}