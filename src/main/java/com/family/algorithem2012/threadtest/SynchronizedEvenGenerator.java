package com.family.algorithem2012.threadtest;

public class SynchronizedEvenGenerator extends InGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecks.test(new SynchronizedEvenGenerator());
    }
}
