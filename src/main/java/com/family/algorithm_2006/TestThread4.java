package com.family.algorithm_2006;

import java.util.Map;

//多线程操作同一个资源
public class TestThread4 implements Runnable {

    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第 " + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
        new Thread(ticket, "黄牛").start();
        new Thread(ticket, "黄牛").start();
    }
}


class Race implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i%10 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 跑了 " + i + "步");
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println(winner + "赢了");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();

    }

}

class Race2 implements Runnable {
    private static String winner;
    private static int tuzinum;
    private static int wuguinum;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            String threadName = Thread.currentThread().getName();
//            if (threadName.equals("兔子") && i % 10 == 0) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            if(gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 跑了 " + i + "步");
            if (threadName.equals("兔子")) {
                tuzinum++;
            } else {
                wuguinum++;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                int num = 0;
                winner = Thread.currentThread().getName();
                if (winner.equals("兔子")) {
                    num = tuzinum;
                } else {
                    num = wuguinum;
                }
                System.out.println(winner + "赢了，共跑了 " + num + "步！");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race2 race = new Race2();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }

}

class StacticProxy {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("好开心");
    }
}

class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款！");
    }
    private void before() {
        System.out.println("结婚之前，布置现场！");
    }
}
