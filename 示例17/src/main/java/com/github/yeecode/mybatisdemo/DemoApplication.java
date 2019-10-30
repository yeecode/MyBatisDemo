package com.github.yeecode.mybatisdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        simpleRef();
        refWithReferenceQueue();
    }

    private static void simpleRef() {
        // 通过等号直接建立的引用都是强引用
        User user = new User();

        // 通过SoftReference建立的引用是软引用
        SoftReference<User> softRefUser =new SoftReference<>(new User());

        // 通过WeakReference建立的引用是弱引用
        WeakReference<User> weakRefUser = new WeakReference<>(new User());
    }

    private static void refWithReferenceQueue() {
        // 创建ReferenceQueue
        // 即我们的小木桶
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        // 用来存储弱引用的目标对象
        // 即我们用来抓带有雪糕的雪糕棒的手
        List<WeakReference> weakRefUserList = new ArrayList<>();
        // 创建大量的弱引用对象，交给weakRefUserList引用
        // 即创建许多带有雪糕的雪糕棒，并且拿到手里
        for (int i =0 ; i< 1000000; i++) { // 创建这么多的目的是为了让内存空间紧张
            // 创建弱引用对象，并在此过程中传入ReferenceQueue
            // 即将雪糕放到雪糕棒上，并且确定用来收集雪糕棒的小木桶
            WeakReference<User> weakReference = new WeakReference(new User(Math.round(Math.random() * 1000)),referenceQueue);
            // 引用弱引用对象
            // 即抓起这个带有雪糕的雪糕棒
            weakRefUserList.add(weakReference);
        }

        WeakReference weakReference;
        Integer count = 0;

        // 处理被回收的弱引用
        // 即通过检查小木桶，处理没有了雪糕的雪糕棒
        while ((weakReference = (WeakReference) referenceQueue.poll()) != null) {
            // 虽然弱引用存在，但是引用的目标对象已经为空
            // 即虽然雪糕棒在木桶中，但是雪糕棒上却没有了雪糕
            System.out.println("JVM 清理了：" + weakReference + ", 从WeakReference中取出对象值为：" + weakReference.get());
            count ++;
        }

        // 被回收的弱引用总数
        // 即小木桶中雪糕棒的数目，也是融化的雪糕的数目
        System.out.println("weakReference中的元素数目为：" + count);

        // 在弱引用的目标对象不被清理时，可以引用到目标对象
        // 即在雪糕还没有融化掉到地上时，雪糕棒上是有雪糕的
        System.out.println("在不被清理的情况下，可以从WeakReference中取出对象值为：" +
                new WeakReference(new User(Math.round(Math.random() * 1000)),referenceQueue).get());
    }
}
