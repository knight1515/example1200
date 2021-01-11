package com.family.algorithem2012.thread2;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TaskWithResult3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Task task = new Task();
        task.bin();
        return "副线任务完成";
    }
}
public class CallableDemo3 {
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        useMain();
        long endTime = new Date().getTime();
        System.out.println((endTime - startTime));
    }
    private static void useMain() {
        Task task = new Task();
        for (int i = 0; i < 100; i++) {
            task.bin();
        }
    }
    private static void useThread() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.submit(new TaskWithResult3());
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                System.out.println("副线执行完成！");
                break;
            }
        }
    }
}

class Task {
    public void bin() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}