package com.family.algorithem2012.threadtest;

public class VolatileGenerator extends InGenerator {
    private volatile int currentValue;
    @Override
    public int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecks.test(new VolatileGenerator());
    }
}
