package com.family.algorithm_2006;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ThreadTest {
    private static LinkedList<String> myQueue = new LinkedList<>();
    private static Object myLock = new Object();

    public static class MySynchronizedTest implements Runnable{

        private String myThreadName;
        public MySynchronizedTest(String myThreadName) {
            this.myThreadName = myThreadName;
        }

        public String getMyThreadName() {
            return myThreadName;
        }

        public void setMyThreadName(String myThreadName) {
            this.myThreadName = myThreadName;
        }

        private void doConsume() throws Exception {
            synchronized (myLock) {
                if (ThreadTest.myQueue.isEmpty()) {
                    System.out.println("消费者等待");
                    myLock.wait();
                }
                String myFirst = myQueue.pop();
                System.out.println(String.format("[%s]:%s", myThreadName, myFirst));
                myLock.notify();
            }
        }

        private void doProduct() throws Exception {
            synchronized (myLock) {
                if (5 < myQueue.size()) {
                    System.out.println("生产者等待！");
                    myLock.wait();
                }
                SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                myQueue.push(sd.format(new Date()));
                myLock.notify();
            }
        }

        @Override
        public void run() {
            try{
                if ("Consumer".equalsIgnoreCase(myThreadName)) {
                    int count = 50;
                    while (0 < count) {
                        doConsume();
                        Thread.sleep(1000);
                        --count;
                    }
                } else {
                    int count = 30;
                    while (0 < count) {
                        doProduct();
                        Thread.sleep(500);
                        --count;
                    }
                    System.out.println("生成完毕");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
