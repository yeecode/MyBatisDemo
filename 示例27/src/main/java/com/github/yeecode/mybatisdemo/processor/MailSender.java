package com.github.yeecode.mybatisdemo.processor;

import com.github.yeecode.mybatisdemo.model.Performer;

public class MailSender extends Handler {
    @Override
    public void handle(Performer performer) {
        if (performer.getEmail() != null) {
            System.out.println("Send Email to " + performer.getEmail());
        }
    }
}
