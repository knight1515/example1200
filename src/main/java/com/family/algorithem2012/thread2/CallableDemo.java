package com.family.algorithem2012.thread2;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//多线程，从任务中产生返回值
class TaskWithResul implements Callable<String> {
    private int id;
    public TaskWithResul(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        ExecutorService exec = Executors.newFixedThreadPool(3);
//        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i=0; i < 10; i ++) {
            results.add(exec.submit(new TaskWithResul(i)));
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                exec.shutdown();
            }
        }
        long endTime = new Date().getTime();
        System.out.println(endTime - startTime);
    }
}
