package com.github.yeecode.mybatisdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        User oldUser = new User(1,"yee");
        User newUser = new User(1,"yeecode");

        System.out.println("不使用反射，只能比较单一类型的对象：");

        Map<String,String> diffUserMap = diffUser(oldUser,newUser);
        for (Map.Entry entry : diffUserMap.entrySet()) {
            System.out.println("属性" + entry.getKey() + "; 变化为：" + entry.getValue());
        }

        System.out.println("使用反射，可以比较属性不同的各类对象：");

        Map<String,String> diffObjMap = diffObj(oldUser,newUser);
        for (Map.Entry entry : diffObjMap.entrySet()) {
            System.out.println("属性" + entry.getKey() + "; 变化为：" + entry.getValue());
        }

        Book oldBook = new Book("语文",15.7);
        Book newBook = new Book("语文",18.7);
        diffObjMap = diffObj(oldBook,newBook);
        for (Map.Entry entry : diffObjMap.entrySet()) {
            System.out.println("属性" + entry.getKey() + "; 变化为：" + entry.getValue());
        }
    }

    /**
     * 比较两个User对象的属性不同
     * @param oldUser 第一个User对象
     * @param newUser 第二个User对象
     * @return 两个User对象的属性变化
     */
    public static Map<String,String> diffUser(User oldUser, User newUser) {
        Map<String,String> diffMap = new HashMap<>();
        if ((oldUser.getId() == null && newUser.getId() != null) ||
                (oldUser.getId()!= null && !oldUser.getId().equals(newUser.getId())))
        {
            diffMap.put("id","from " + oldUser.getId() + " to " + newUser.getId());
        }
        if ((oldUser.getName() == null && newUser.getName() != null) ||
                (oldUser.getName()!= null && !oldUser.getName().equals(newUser.getName())))
        {
            diffMap.put("name","from " + oldUser.getName() + " to " + newUser.getName());
        }
        return diffMap;
    }

    /**
     * 比较两个任意对象的属性不同
     * @param oldObj 第一个对象
     * @param newObj 第二个对象
     * @return 两个对象的属性变化
     */
    public static Map<String, String> diffObj(Object oldObj, Object newObj) {
        Map<String, String> diffMap = new HashMap<>();
        try {
            // 获取对象的类
            Class oldObjClazz = oldObj.getClass();
            Class newObjClazz = newObj.getClass();
            // 判断两个对象是否属于同一个类
            if (oldObjClazz.equals(newObjClazz)) {
                // 获取对象的所有属性
                Field[] fields = oldObjClazz.getDeclaredFields();
                // 对每个属性逐一判断
                for (Field field : fields) {
                    // 使得属性可以被反射访问
                    field.setAccessible(true);
                    // 拿到当前属性的值
                    Object oldValue = field.get(oldObj);
                    Object newValue = field.get(newObj);
                    // 如果某个属性的值在两个对象中不同，则进行记录
                    if ((oldValue == null && newValue != null) || oldValue != null && !oldValue.equals(newValue)) {
                        diffMap.put(field.getName(), "from " + oldValue + " to " + newValue);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return diffMap;
    }
}
