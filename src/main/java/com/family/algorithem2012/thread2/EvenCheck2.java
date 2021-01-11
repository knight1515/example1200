package com.family.algorithem2012.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class add2 implements Runnable {
    private int num;
    public add2(int num) {
        this.num = num;
    }
    @Override
    public void run() {
        while (true) {
            int val = next();
            System.out.println("线程名：" + Thread.currentThread().getName() + "，数量：" + val);
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                break;
            }
        }
    }

    public int next() {
        ++ num;
        Thread.yield();
        ++ num;
        return num;
    }
}
public class EvenCheck2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int num = 0;
        for(int i = 0; i < 2; i++) {
            exec.submit(new add2(num));
        }
        exec.shutdown();
    }
}
