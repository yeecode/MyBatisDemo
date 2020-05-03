package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

        // 输出包含两个结果的结果集
        System.out.println("--输出包含多个结果的结果集--");
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<List<Object>> result = session.selectList("com.github.yeecode.mybatisdemo.dao.Dao01.query");
            System.out.println("结果集包含结果数目:" + result.size());
            int i = 1;
            for (List<Object> list: result ) {
                System.out.println("结果集" + i++ + ":");
                for (Object o: list) {
                    System.out.println(o.toString());
                }
            }
        }

        // 两个结果合并为一个结果
        System.out.println("--多个结果整合为一个结果--");
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> result = session.selectList("com.github.yeecode.mybatisdemo.dao.Dao02.query");
            System.out.println("结果包含记录数目: " + result.size());
            for (User user: result) {
                System.out.println(user);
            }
        }
    }
}
















