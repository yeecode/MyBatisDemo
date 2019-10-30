package com.github.yeecode.mybatisdemo.processor;

import com.github.yeecode.mybatisdemo.model.Performer;

public class ContactOfficer extends Handler {
    @Override
    public void handle (Performer performer) {
        if(performer.getAge() <  18) {
            System.out.println("Arrange school bus for " + performer.getName());
        }
    }
}
