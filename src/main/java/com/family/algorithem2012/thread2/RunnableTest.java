package com.family.algorithem2012.thread2;

public class RunnableTest implements Runnable {
    private int tick = 60;

    @Override
    public void run() {
        while (true) {
            if (tick == 0) {
                break;
            }
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=======" + tick--);
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest).start();
        new Thread(runnableTest).start();
    }
}
