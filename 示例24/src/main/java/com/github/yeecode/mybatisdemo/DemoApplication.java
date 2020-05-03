package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.Task;
import com.github.yeecode.mybatisdemo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 嵌套查询操作
//        nestedQuery(sqlSessionFactory);

        // 惰性查询操作
        lazyLoadQuery(sqlSessionFactory);

        // 包含序列化与反序列化的惰性查询操作
//        lazyLoadQueryAndSerialize(sqlSessionFactory);

    }

    private static void nestedQuery(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User userParam = new User();
            userParam.setSex(0);
            // 查询满足条件的全部用户
            List<User> userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.nestedQuery", userParam);
            // 打印全部用户姓名列表
            System.out.println("users: ");
            for (User user : userList) {
                System.out.println(user.getName() + "， age = " + user.getAge());
            }
            // 打印用户任务
            System.out.println("userDetail: ");
            for (User user : userList) {
                System.out.println(user.getName() + ":");
                for (Task task : user.getTaskList()) {
                    System.out.println(task.getTaskName());
                }
            }
        }
    }

    private static void lazyLoadQuery(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User userParam = new User();
            userParam.setSex(0);
            // 查询满足条件的全部用户
            List<User> userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.lazyLoadQuery", userParam);
            // 打印全部用户姓名列表
            System.out.println("users: ");
            for (User user : userList) {
                System.out.println(user.getName() + "， age = " + user.getAge());
            }
            // 根据条件打印用户任务信息
            System.out.println("userDetail: ");
            for (User user : userList) {
                if (user.getAge() == 18) {
                    System.out.println(user.getName() + ":");
                    for (Task task : user.getTaskList()) {
                        System.out.println(task.getTaskName());
                    }
                }
            }
        }
    }

    private static void lazyLoadQueryAndSerialize(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            User userParam = new User();
            userParam.setSex(0);
            // 查询满足条件的全部用户
            List<User> userList = session.selectList("com.github.yeecode.mybatisdemo.dao.UserDao.lazyLoadQuery", userParam);

            System.out.println("users: ");
            for (User user : userList) {
                System.out.println(user.getName() + "， age = " + user.getAge());
                user.setSchoolName("New School");
            }

            // 序列化与反序列化操作
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.tempdata"));
            oos.writeObject(userList.get(0));
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.tempdata"));
            User newUser = (User) ois.readObject();
            System.out.println("newUser:" + newUser.getName());

            // 根据条件打印用户任务信息
            System.out.println("userDetail: ");
            for (User user : userList) {
                if (user.getAge() == 18) {
                    System.out.println(user.getName() + ":");
                    for (Task task : user.getTaskList()) {
                        System.out.println(task.getTaskName());
                    }
                }
            }
        } catch (Exception ex) {
        }
    }
}
