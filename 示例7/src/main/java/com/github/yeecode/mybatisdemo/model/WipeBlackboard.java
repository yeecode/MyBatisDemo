package com.github.yeecode.mybatisdemo.model;

public class WipeBlackboard extends Cleaning {
    @Override
    void prepare() {
        System.out.println("找到黑板檫。");
    }

    @Override
    void implement() {
        System.out.println("用力擦黑板。");
    }

    @Override
    void windup() {
        System.out.println("清理粉笔屑。");
    }
}
