package com.github.yeecode.mybatisdemo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        String[] record = {"易哥:4","杰克:5","易哥:1","杰克:7","张大壮:3"};

        System.out.println("使用原生Map:");
        Map<String, List<Integer>> taskMap = new HashMap<>();
        for (String item : record) {
            String key = item.split(":")[0];
            Integer value = Integer.parseInt(item.split(":")[1]);
            taskMap.putIfAbsent(key,new ArrayList<>());
            taskMap.get(key).add(value);
        }
        System.out.println(taskMap);

        System.out.println("使用Multimap：");
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        for (String item : record) {
            String key = item.split(":")[0];
            Integer value = Integer.parseInt(item.split(":")[1]);
            multimap.put(key,value);
        }
        System.out.println(multimap.asMap());

    }
}
