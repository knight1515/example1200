package com.shang.weng.template1101;

public class HummerModelH2 extends HummerModel{

    @Override
    public void start() {
        System.out.println("H2开始");
    }

    @Override
    public void stop() {
        System.out.println("H2停止");
    }

    @Override
    public void alarm() {
        System.out.println("H2鸣笛");
    }

    @Override
    public void engineBoom() {
        System.out.println("H2引擎轰鸣");
    }
}
