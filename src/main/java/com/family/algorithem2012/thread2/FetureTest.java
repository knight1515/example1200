package com.family.algorithem2012.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FetureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<?> submit = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                int i = 5;
                while (i >= 0) {
                    try {
                        System.out.println("正在执行线程！i=" + i);
                        Thread.sleep(1000);
                        i--;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        while (true) {
           if (submit.isDone()) {
               break;
           }
            System.out.println("主线程正在等待");
           try {
               Thread.sleep(5000);
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
        System.out.println("执行完成");
    }
}
