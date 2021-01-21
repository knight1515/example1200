package com.family.algorithem2101.threedd;

public class ThreadDemo implements Runnable {

    private static int i=0;
    @Override
    public void run() {
        while (true) {
        i++;
        Thread.yield();
        i++;
        System.out.println(Thread.currentThread().getName() + ":" + i);
        if (i%2 != 0){
            System.out.println(Thread.currentThread().getName() + ":" +i);
            break;
        }
        }
    }
}


