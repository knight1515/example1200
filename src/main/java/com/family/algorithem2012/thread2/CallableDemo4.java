package com.family.algorithem2012.thread2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult4 implements Callable<Integer> {
    Integer n = new Integer(0);
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            n ++;
        }
        return n;
    }
}
public class CallableDemo4 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult4()));
        }
        for (Future<Integer> future : results) {
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                exec.shutdown();
            }
        }
    }
}
