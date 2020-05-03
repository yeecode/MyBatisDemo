package com.github.yeecode.mybatisdemo;

public class PhoneRecordDecorator implements Phone {
    private Phone decoratedPhone;

    public PhoneRecordDecorator(Phone decoratedPhone) {
        this.decoratedPhone = decoratedPhone;
    }

    @Override
    public String callIn() {
        System.out.println("启动录音……");
        String info = decoratedPhone.callIn();
        System.out.println("结束录音并保存录音文件。");
        return info;
    }

    @Override
    public Boolean callOut(String info) {
        System.out.println("启动录音……");
        Boolean result = decoratedPhone.callOut(info);
        System.out.println("结束录音并保存录音文件。");
        return result;
    }
}
