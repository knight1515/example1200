package com.family.algorithm_2006;

import org.w3c.dom.css.Counter;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class ThreadWar {
    private BigInteger lastNumber;
    private long hits;
    private long cacheHits;

    public void testThread() {
        int num = 0;

    }
    private BigInteger[] lastFactors;
    public void numAdd(Integer i) {
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++ cacheHits;
                factors = lastFactors.clone();
            }
        }

        if (factors == null) {
            synchronized (this) {
                lastFactors = factors.clone();
            }
        }
    }
}

class SynchronizdFactorizer implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    private BigDecimal lastNumber;
    private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

class NoVisibility {
    private static boolean ready;
    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        System.out.println(ready);
        number = 42;
        ready = true;
        System.out.println(Thread.currentThread().getName());
    }

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println("ReaderThread: " + Thread.currentThread().getName());
                Thread.yield();
                System.out.println(number);
            }
        }
    }

}

class SynchronizedInteger {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}

class VoLock {
    private int value;

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
        thread1.start();
    }

    void doubleSynchor() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "：线程进入");
            value = 10;
            Thread.sleep(5000L);
            System.out.println("同步1：" + value);
        }

        synchronized (this) {
            System.out.println(value);
        }
    }

}

class Thread1 extends Thread{
    @Override
    public void run() {
        VoLock vl = new VoLock();
        try {
            vl.doubleSynchor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1: " + Thread.currentThread().getName());
        super.run();
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        VoLock vl = new VoLock();
        try {
            vl.doubleSynchor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2: " + Thread.currentThread().getName());
        super.run();

    }
}


/**
 * 对象不可变，其中的【getFactors】方法就是线程安全的。
 */
class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = lastFactors;
    }
    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}

/**
 * Runnable和Thread的区别
 */
class ThreadCreationCmp {
    public static void main(String[] args) {
        Thread t;
        CountingRunnable ct = new CountingRunnable();

        final int numberOfProceesors = Runtime.getRuntime().availableProcessors();
        System.out.println("本机处理器数量：" + numberOfProceesors);

        for (int i = 0; i< 2 * numberOfProceesors; i++) {
            t = new Thread(ct);
            t.start();
        }

        for (int i = 0; i < 2 * numberOfProceesors; i++) {
            t = new CountingThread();
            t.start();
        }
    }

    static class Counter {
        private int count = 0;
        public void increment() {
            count++;
        }
        public int value() {
            return count;
        }
    }

    static class CountingRunnable implements Runnable {
        private Counter counter = new Counter();
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingRunnable:" + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(80L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class CountingThread extends Thread {
        private Counter counter = new Counter();
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println("CountingThread:" + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(80L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 1-6简易的倒计时器
 */
class SimpleTimer {
    private static int count;

    public static void main(String[] args) {
        count = args.length >= 1 ? Integer.valueOf(args[0]) : 60;
        int remaining;
        while (true) {
            remaining = countDown();
            if (0 == remaining) {
                break;
            } else {
                System.out.println("Remaining " + count + " second(s)");
            }

            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done.");
    }

    private static int countDown() {
        return count--;
    }
}
