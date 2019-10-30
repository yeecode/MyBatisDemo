package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.Performer;
import com.github.yeecode.mybatisdemo.processor.ContactOfficer;
import com.github.yeecode.mybatisdemo.processor.Handler;
import com.github.yeecode.mybatisdemo.processor.MailSender;
import com.github.yeecode.mybatisdemo.processor.MaterialManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        Performer performer01 = new Performer("易哥", "yeecode@sample.com", 18, 0, "Sunny School");
        Performer performer02 = new Performer("莉莉", "lili@sample.com", 15, 1, "Garden School");
        Performer performer03 = new Performer("杰克", "jack@sample.com", 25, 0, "Sunny School");
        Performer performer04 = new Performer("张大壮", "zdazhaung@sample.com", 16, 0, "Garden School");

        List<Performer> performerList = Arrays.asList(new Performer[]{performer01, performer02, performer03, performer04});

        // 不使用责任链模式
        System.out.println("不使用责任链模式：");
        // 创建三个工作人员实例
        MailSender mailSender = new MailSender();
        MaterialManager materialManager = new MaterialManager();
        ContactOfficer contactOfficer = new ContactOfficer();
        // 依次处理每个参与者
        for (Performer performer : performerList) {
            System.out.println("process " + performer.getName() + ":");
            new MailSender().handle(performer);
            new MaterialManager().handle(performer);
            new ContactOfficer().handle(performer);
            System.out.println("---------");
        }

        // 使用责任链模式
        System.out.println("使用责任链模式：");
        // 创建责任链
        Handler handlerChain = new MailSender();
        handlerChain.setNextHandler(new MaterialManager()).setNextHandler(new ContactOfficer());

        // 依次处理每个参与者
        for (Performer performer : performerList) {
            System.out.println("process " + performer.getName() + ":");
            handlerChain.triggerProcess(performer);
            System.out.println("---------");
        }

    }
}


