package com.github.yeecode.mybatisdemo;

public class TelePhone implements Phone {
    @Override
    public String callIn() {
        System.out.println("接受语音……");
        return "get info";
    }

    @Override
    public Boolean callOut(String info) {
        System.out.println("发送语音：" + info);
        return true;
    }
}
