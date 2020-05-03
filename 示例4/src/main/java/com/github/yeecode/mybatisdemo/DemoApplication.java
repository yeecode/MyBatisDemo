package com.github.yeecode.mybatisdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        System.out.println("--原有Phone无录音功能--");
        Phone phone = new TelePhone();
        phone.callOut("Hello, this is yee.");

        System.out.println();

        System.out.println("--经过装饰后的Phone有录音功能--");
        Phone phoneWithRecorder = new PhoneRecordDecorator(phone);
        phoneWithRecorder.callOut("Hello, this is yee.");


        // 有短信功能的Phone
        Phone phoneWithMessage = new PhoneMessageDecorator(phone);
        ((PhoneMessageDecorator) phoneWithMessage).sendMessage("Hello, this is yee.");

    }
}
