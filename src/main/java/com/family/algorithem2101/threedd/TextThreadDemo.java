package com.family.algorithem2101.threedd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TextThreadDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i=0; i<10; i++) {
            executor.execute(new ThreadDemo());
        }
        executor.shutdown();
    }
}
