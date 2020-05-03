package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.UserModel01;
import com.github.yeecode.mybatisdemo.model.UserModel02;
import com.github.yeecode.mybatisdemo.model.UserModel03;
import com.github.yeecode.mybatisdemo.model.UserModel04;
import com.github.yeecode.mybatisdemo.model.UserModel05;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        try {
            // 继承Serializable对象的序列化和反序列化
            demo01();

            // 继承Externalizable对象的序列化和反序列化
            demo02();

            // writeReplace方法测试
            demo03();

            // readResolve方法测试
            demo04();

            // writeExternal/readExternal/writeReplace/readResolve执行顺序测试
            demo05();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void demo01() throws Exception {
        System.out.println("run demo01:");
        UserModel01 userModel01 = new UserModel01();
        userModel01.setId(1);
        userModel01.setName("易哥");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("m1.tempdata"));
        oos.writeObject(userModel01);
        oos.flush();
        oos.close();

        System.out.println("↑write;↓read");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("m1.tempdata"));
        UserModel01 newUser = (UserModel01) ois.readObject();
        System.out.println("newUser:" + newUser.getId() + "-" + newUser.getName());
        System.out.println();
    }

    private static void demo02() throws Exception {
        System.out.println("run demo02:");
        UserModel02 userModel02 = new UserModel02();
        userModel02.setId(1);
        userModel02.setName("易哥");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("m2.tempdata"));
        oos.writeObject(userModel02);
        oos.flush();
        oos.close();

        System.out.println("↑write;↓read");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("m2.tempdata"));
        UserModel02 newUser = (UserModel02) ois.readObject();
        System.out.println("newUser:" + newUser.getId() + "-" + newUser.getName());
        System.out.println();
    }

    private static void demo03() throws Exception {
        System.out.println("run demo03:");
        UserModel03 userModel03 = new UserModel03();
        userModel03.setId(1);
        userModel03.setName("易哥");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("m3.tempdata"));
        oos.writeObject(userModel03);
        oos.flush();
        oos.close();

        System.out.println("↑write;↓read");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("m3.tempdata"));
        UserModel03 newUser = (UserModel03) ois.readObject();
        System.out.println("newUser:" + newUser.getId() + "-" + newUser.getName());
        System.out.println();
    }

    private static void demo04() throws Exception {
        System.out.println("run demo04:");
        UserModel04 userModel04 = new UserModel04();
        userModel04.setId(1);
        userModel04.setName("易哥");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("m4.tempdata"));
        oos.writeObject(userModel04);
        oos.flush();
        oos.close();

        System.out.println("↑write;↓read");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("m4.tempdata"));
        UserModel04 newUser = (UserModel04) ois.readObject();
        System.out.println("newUser:" + newUser.getId() + "-" + newUser.getName());
        System.out.println();
    }

    private static void demo05() throws Exception {
        System.out.println("run demo05:");
        UserModel05 userModel05 = new UserModel05();
        userModel05.setId(1);
        userModel05.setName("易哥");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("m5.tempdata"));
        oos.writeObject(userModel05);
        oos.flush();
        oos.close();

        System.out.println("↑write;↓read");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("m5.tempdata"));
        UserModel05 newUser = (UserModel05) ois.readObject();
        System.out.println("newUser:" + newUser.getId() + "-" + newUser.getName());
        System.out.println("description:" + newUser.getDescription());
        System.out.println();
    }
}
