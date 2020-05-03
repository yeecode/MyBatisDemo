package com.github.yeecode.mybatisdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    // 创建了两个ThreadLocal变量
    private static ThreadLocal<Integer> threadLocalNumber = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocalString = new ThreadLocal<>();

    public static void main(String[] args) {
        try {
            Thread thread01 = new Thread(new Task01());
            Thread thread02 = new Thread(new Task02());
            thread01.start();
            thread02.start();
            Thread.sleep(2L);
            System.out.println("Main-number: " + threadLocalNumber.get());
            System.out.println("Main-string: " + threadLocalString.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static class Task01 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread01-number: " + threadLocalNumber.get());
            System.out.println("Set Thread01-number : 3001");
            threadLocalNumber.set(3001);
            System.out.println("Thread01-number: " + threadLocalNumber.get());
            System.out.println("Set Thread01-string : hello thread01");
            threadLocalString.set("hello thread01");
            System.out.println("Thread01-string: " + threadLocalString.get());
        }
    }

    private static class Task02 implements Runnable {
        @Override
        public void run() {
            System.out.println("Set Thread02-number : 3002");
            threadLocalNumber.set(3002);
            System.out.println("Thread02-number: " + threadLocalNumber.get());
            System.out.println("Thread02-string: " + threadLocalString.get());
            System.out.println("Set Thread02-string : hello thread02");
            threadLocalString.set("hello thread02");
            System.out.println("Thread02-string: " + threadLocalString.get());
        }
    }
}

