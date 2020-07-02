package com.com.countdownlatch;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(1000);
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
//                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("countdownlatch 执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Thread(()->{
//                System.out.println(Thread.currentThread().getName());
            }));
        }

        for (Thread thread : list) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("normal thread 执行完毕");

    }
}
