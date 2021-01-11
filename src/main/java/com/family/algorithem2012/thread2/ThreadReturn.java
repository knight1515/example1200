package com.family.algorithem2012.thread2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult (int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        return name + ":result of TaskWithResult " + id;
    }
}
public class ThreadReturn {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executor.submit(new TaskWithResult(i)));
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
