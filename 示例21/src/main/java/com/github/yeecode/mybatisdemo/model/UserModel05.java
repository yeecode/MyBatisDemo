package com.github.yeecode.mybatisdemo.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class UserModel05 implements Externalizable {
    private static final long serialVerisionUID = 1L;

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal doing ...");
        out.write(id);
        out.writeObject(name + "（from writeExternal）");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal doing ...");
        id = in.read();
        name = (String) in.readObject();
        System.out.println("name in file is：" + name);
        name = name + "(from readExternal)";
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace doing ...");
        UserModel05 userModel = new UserModel05();
        userModel.setId(2);
        userModel.setName(name + "(from writeReplace)");
        userModel.setDescription("description from writeReplace");
        return userModel;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve doing ...");
        UserModel05 userModel = new UserModel05();
        userModel.setId(2);
        userModel.setName(name + "(from readResolve)");
        userModel.setDescription("description from readResolve");
        return userModel;
    }
}
