package com.github.yeecode.mybatisdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws Exception {
        // 首先获取Connection对象备用，也可以使用其他方式获取
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Connection connection = sqlSession.getConnection();

        // SqlRunner类的使用
        String sql = "SELECT * FROM user WHERE age = ?;";
        SqlRunner sqlRunner = new SqlRunner(connection);
        List<Map<String, Object>> result = sqlRunner.selectAll(sql,15);
        System.out.println(result);

        // SqlRunner类的使用，email变量值为null
        sql = "UPDATE user SET email = ?  WHERE id = 2;";
        Integer out = sqlRunner.update(sql,Null.STRING);
        System.out.println(out);

        // ScriptRunner类的使用
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.runScript(Resources.getResourceAsReader("demoScript.sql"));

        connection.close();
    }
}
