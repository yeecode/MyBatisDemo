package com.github.yeecode.mybatisdemo;

public class PhoneMessageDecorator implements Phone {
    private Phone decoratedPhone;

    public PhoneMessageDecorator(Phone decoratedPhone) {
        this.decoratedPhone = decoratedPhone;
    }

    @Override
    public String callIn() {
        return decoratedPhone.callIn();
    }

    @Override
    public Boolean callOut(String info) {
        return decoratedPhone.callOut(info);
    }

    public String receiveMessage() {
        // 省略接受短信操作
        return "receive message";
    }

    public Boolean sendMessage(String info) {
        // 省略发送短信操作
        return true;
    }
}
