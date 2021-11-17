package com.desinpattern.proxy;

public class TestYield {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    MyThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(getName() + ":" + i);
            if (("t1").equals(getName())) {
                if (i == 0) {
                    yield();
                }
            }
        }
    }
}
