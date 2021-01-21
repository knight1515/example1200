package com.family.algorithem2012.threadtest;

public abstract class InGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
