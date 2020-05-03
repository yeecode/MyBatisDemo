package com.github.yeecode.mybatisdemo.processor;

import com.github.yeecode.mybatisdemo.model.Performer;

public class MaterialManager extends Handler {
    @Override
    public void handle(Performer performer) {
        System.out.println("Prepare clothes for a " + (performer.getSex() == 0 ? "Boy" : "Girl"));
    }
}
