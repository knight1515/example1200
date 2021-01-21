package com.family.algorithem2012.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetureTest2 {
    public static void main(String[] args) {
        try{
            ExecutorService excutor = Executors.newFixedThreadPool(7);
            for (int i = 0 ; i<10; i++) {
                AnyTask anyTask = new AnyTask();
                excutor.execute(anyTask);
            }
            excutor.shutdown();

            while (true) {
                if (excutor.isTerminated()) {
                    EndTask endTask = new EndTask();
                    endTask.taskRun();
                    break;
                } else {
                    Thread.sleep(3000);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AnyTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "普通任务执行完成！");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class EndTask {
    public void taskRun(){
        try {
            System.out.println("开始执行最终任务！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}