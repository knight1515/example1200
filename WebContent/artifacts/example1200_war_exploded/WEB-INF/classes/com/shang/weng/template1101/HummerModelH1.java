package com.shang.weng.template1101;

public class HummerModelH1 extends HummerModel {

    @Override
    public void start() {
        System.out.println("H1开始");
    }

    @Override
    public void stop() {
        System.out.println("H1停止");
    }

    @Override
    public void alarm() {
        System.out.println("H1鸣笛");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1引擎轰鸣");
    }
}
