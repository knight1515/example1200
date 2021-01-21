package com.family.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 实现项目启动后执行某个任务配合Timer、TimerTask
 */
public class TimerLintener implements ServletContextListener {
    private Timer temProfileTimer = new Timer();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            temProfileTimer.schedule(new TemProfileTask(),0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        temProfileTimer.cancel();
        temProfileTimer.purge();
    }
}

class TemProfileTask extends TimerTask {
    public TemProfileTask() {

    }
    /**
     * 实现了【正式业务代码】处理完成后，
     */
    @Override
    public void run() {
        Long time = 5000L;
        while (true) {
            try {
                Thread.sleep(time);
                SimpleDateFormat sdf = new SimpleDateFormat("hh:MM:ss");
                //正式的业务代码
                System.out.println("正式业务代码！执行时间：" + sdf.format(new Date()) + "线程名称为：" + Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}