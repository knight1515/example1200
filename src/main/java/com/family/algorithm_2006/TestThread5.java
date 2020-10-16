package com.family.algorithm_2006;

public class TestThread5 implements Runnable{
    private int ticketNum = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread5 ticket = new TestThread5();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
    }
}
