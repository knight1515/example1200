package com.family.algorithem2012.thread2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult5 implements Callable<String> {
    private int id;
    public TaskWithResult5(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        return "result of TaskWithResult5 " + name +id;
    }
}
public class CallableDemo5 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(new TaskWithResult5(i)));
        }

        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                executor.shutdown();
            }
        }
    }
}
