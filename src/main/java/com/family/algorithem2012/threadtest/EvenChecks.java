package com.family.algorithem2012.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecks implements Runnable {

    private InGenerator generator;

    public EvenChecks(InGenerator g) {
        generator = g;
    }
    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }
    public static void test(InGenerator gp, int cont) {
        System.out.println("Press Controll-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < cont; i++) {
            exec.execute(new EvenChecks(gp));
        }
        exec.shutdown();
    }
    public static void test(InGenerator gp) {
        test(gp, 2);
    }
}

class testStation {
    private int n = 0;
    public void run() {
        while (!isCanceled()) {
            n ++;
            n ++;
            if (n % 2 != 0) {
                System.out.println(n + " not even!");
                cancel();
            }
        }
    }
    private volatile boolean canceled = false;
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
