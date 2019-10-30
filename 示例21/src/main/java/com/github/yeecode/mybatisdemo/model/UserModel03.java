package com.github.yeecode.mybatisdemo.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class UserModel03 implements Serializable {
    private static final long serialVerisionUID = 123L;

    private Integer id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace doing ...");
        UserModel03 userModel = new UserModel03();
        userModel.setId(2);
        userModel.setName("yeecode");
        userModel.setDescription("description from writeReplace");
        return userModel;
    }
}
