package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.User;
import ognl.Ognl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        try {
            User user01 = new User(1, "易哥", 18);
            User user02 = new User(2, "莉莉", 15);
            Map<String, User> userMap = new HashMap<>();
            userMap.put("user1", user01);
            userMap.put("user2", user02);

            // Java方式读取列表中对象的属性值
            String userName = userMap.get("user2").getName();
            System.out.println(userName);

            readAndWriteProps(userMap);
            callFunction();
            runAfterParse(userMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void readAndWriteProps(Map<String, User> userMap) throws Exception {
        // 使用表达式读写根对象中信息的示例
        // 该示例中要用到的OGNL函数：
        // getValue(String expression, Object root) ：对root内容执行expression中的操作，并返回结果

        // 读取根对象的属性值
        Integer age = (Integer) Ognl.getValue("age", userMap.get("user1"));
        System.out.println("读取根对象属性，得到age：" + age);
        // 设置根对象的属性值
        Ognl.getValue("age = 19", userMap.get("user1"));
        age = (Integer) Ognl.getValue("age", userMap.get("user1"));
        System.out.println("设置根对象属性后，得到age：" + age);

        // 使用表达式读写环境中信息的示例
        // 该示例中要用到的OGNL函数：
        // getValue(String expression, Map context, Object root) ：在context环境中对root内容执行expression中的操作，并返回结果

        // 读取环境中的信息
        String userName2 = (String) Ognl.getValue("#user2.name", userMap, new Object());
        System.out.println("读取环境中的信息，得到user2的name：" + userName2);
        // 读取环境中的信息，并进行判断
        Boolean result = (Boolean) Ognl.getValue("#user2.name != '丽丽'", userMap, new Object());
        System.out.println("读取环境中的信息，并进行判断，得到：" + result);
        // 设置环境中的信息
        Ognl.getValue("#user2.name = '小华'", userMap, new Object());
        String newUserName = (String) Ognl.getValue("#user2.name", userMap, new Object());
        System.out.println("设置环境中的信息后，得到user2的name：" + newUserName);
    }

    public static void callFunction() throws Exception {
        // 调用对象方法
        Integer hashCode = (Integer) Ognl.getValue("hashCode()", "yeecode");
        System.out.println("对字符串对象调用hashCode方法得到：" + hashCode);
        // 调用类方法
        Double result = (Double)Ognl.getValue("@java.lang.Math@random()", null);
        System.out.println("调用Math类中的静态方法random，得到：" + result);
    }

    public static void runAfterParse(Map<String, User> userMap) throws Exception {
        String userName;

        // 先对表达式解析，然后再执行可以提高效率
        long time1 = new Date().getTime();
        // 解析表达式
        Object expressionTree = Ognl.parseExpression("#user2.name");
        // 重复运行多次
        for (int i = 0; i < 10000; i++) {
            userName = (String) Ognl.getValue(expressionTree, userMap, new Object());
        }
        long time2 = new Date().getTime();
        // 直接重复运行多次
        for (int i = 0; i < 10000; i++) {
            userName = (String) Ognl.getValue("#user2.name", userMap, new Object());
        }
        long time3 = new Date().getTime();

        System.out.println("编译之后再执行，共花费" + (time2 - time1) + "ms");
        System.out.println("不编译直接执行，共花费" + (time3 - time2) + "ms");
    }

}
