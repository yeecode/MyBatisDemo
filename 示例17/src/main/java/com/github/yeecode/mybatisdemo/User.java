package com.github.yeecode.mybatisdemo;

public class User {
    private long id;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User:" + id;
    }
}
