package com.github.yeecode.mybatisdemo;

import com.github.yeecode.mybatisdemo.model.WipeGlass;
import com.github.yeecode.mybatisdemo.model.Cleaning;
import com.github.yeecode.mybatisdemo.model.WipeBlackboard;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        Cleaning wipeGlass = new WipeGlass();
        wipeGlass.clean();

        Cleaning wipeBlackboard = new WipeBlackboard();
        wipeBlackboard.clean();
    }
}
