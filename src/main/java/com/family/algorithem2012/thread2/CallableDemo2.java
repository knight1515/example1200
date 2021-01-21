package com.family.algorithem2012.thread2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult2 implements Callable<Map> {
    private int num;
    public TaskWithResult2(int num){
        this.num = num;
    }
    @Override
    public Map call() throws Exception {
        Map resultMap = new HashMap();
        for (int i = 0; i < num; i++) {
            resultMap.put(i, i+"的值");
        }
        return resultMap;
    }
}
public class CallableDemo2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ArrayList<Future<Map>> results = new ArrayList<>();
        for (int i = 3; i < 10; i++) {
            results.add(executor.submit(new TaskWithResult2(i)));
        }
        for (Future<Map> fs : results) {
            try {
                Map map = fs.get();
                System.out.println(map.size());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                executor.shutdown();
            }
        }
    }
}
