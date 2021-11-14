package com.shang.weng.stack02;

public class TestNotifyNotifyAll {
    private static Object obj = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunA(obj));
        thread1.start();
//        Thread thread3 = new Thread(new RunA(obj));
//        thread3.start();

        Thread thread2 = new Thread(new RunB(obj));
        thread2.start();
    }

}
class RunA implements Runnable {
    private Object obj;

    public RunA(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("进入——A");
        synchronized (obj) {
            System.out.println("obj to wait on RunA");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RunA 结束");
        }
    }
}

class RunB implements Runnable {
    private Object obj;

    public RunB(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("to —— RunB");
        System.out.println("睡眠3秒---");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("RunB to notify!");
            obj.notify();
        }
    }
}
