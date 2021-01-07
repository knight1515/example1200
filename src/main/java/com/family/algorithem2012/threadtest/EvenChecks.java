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
