package com.family.algorithem2012.thread2;

public class Station extends Thread {
    public Station(String name) {
        super(name);
    }

    static int tick = 20;

    @Override
    public void run() {
        while (tick > 0) {
            if (tick >0) {
                System.out.println(getName() + "卖出了第" + tick + "张票");
                tick --;
            } else {
                System.out.println("票卖完了！");
            }
        }
        try {
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
