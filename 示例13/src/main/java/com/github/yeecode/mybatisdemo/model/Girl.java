package com.github.yeecode.mybatisdemo.model;

public class Girl extends User {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                +"Girl{" +
                "email=" + email +
                '}';
    }
}
