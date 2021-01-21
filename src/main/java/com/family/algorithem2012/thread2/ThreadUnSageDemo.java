package com.family.algorithem2012.thread2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class ThreadUnSageDemo {
    private static int value = 1;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(() -> {
                while (true) {
                    System.out.println("正在出票：" + (value ++));
                    if (value > 20) {
                        latch.countDown();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        latch.await();
        System.out.println("执行完毕 ---");
    }
}
