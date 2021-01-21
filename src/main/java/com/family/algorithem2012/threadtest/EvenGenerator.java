package com.family.algorithem2012.threadtest;

public class EvenGenerator extends InGenerator {

    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }


    public static void main(String[] args) {
        EvenChecks.test(new EvenGenerator());
    }
}
