package com.family.algorithem2012.thread2;

public class SellerSystem {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (ticket.sell() > 0) {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (ticket.sell() > 0) {
                }
            }
        }).start();
    }
}

class Ticket {
    public int count = 118;
    public int sell() {
        System.out.println(Thread.currentThread().getName() + ":还剩下" + count + "张票");
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return --count;
    }
}