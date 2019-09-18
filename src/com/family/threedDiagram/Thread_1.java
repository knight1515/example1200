package com.family.threedDiagram;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Thread_1 {
	public static void main(String[] args) {
		Thread_1 th=new Thread_1();
//		th.onlyThreed();
		
		th.singleThread();
	}
	
	/**
	 * 单一主线程,执行时一条线
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午8:58:15
	 */
	private void onlyThreed() {
		for(int i =0;i<10000;i++){
			System.out.print("Good!");
		}
	}
	
	//在这个方法中调用了新线程
	private void callThread() {
		MyThread mt=new MyThread();
		mt.start();//调用多线程
		
		for(int i=0;i<10000;i++){
			System.err.print("Good!");
		}
	}
	
	/**
	 * 调用Thread抽象类
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午9:24:52
	 */
	private void callPrintThread(){
		//线程实例和线程本身不是一回事.
		//不调用start,线程不会启动
		new PrintThread("Good!").start();
		new PrintThread("Nice!").start();
	}
	
	/**
	 * 调用用接口Runnable实现的线程类
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午9:31:05
	 */
	private void callPrinter() {
		
		new Thread(new Printer("Good!")).start();
		new Thread(new Printer("Nice!")).start();
	}
	
	/**
	 * 利用ThreadFactory启动线程
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午11:05:49
	 */
	private void byThreadFactory() {
		ThreadFactory  factory = Executors.defaultThreadFactory();
		factory.newThread(new Printer("Nice!")).start();
	}
	
	/**
	 * 利用Thread.sleep(1000)暂停线程的执行
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午11:10:46
	 */
	private void useSleep() {
		for(int i=0;i<10;i++){
			System.out.println("Good!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @author: gzb
	 * @date  : 2019年9月18日 下午11:46:50
	 */
	private void singleThread() {
		System.out.println("Testing Gate, hit CTRL+C to exit.");
		
		Gate gate = new Gate();
		new UserThread(gate, "Alice", "Alaska").start();
		new UserThread(gate, "Bobby", "Brazil").start();
		new UserThread(gate, "Chris", "Canada").start();
	}
}

/**
 * 以继承Thread的方式编写一个新线程，
 * 这个线程需要主线程中调用才会启动，才算多线程程序
 * 
 * @author: gzb
 * @date  : 2019年9月18日 下午9:03:41
 *
 */
class MyThread extends Thread{
	@Override
	public void run(){
		for(int i=0; i<10000;i++){
			System.out.print("Nice!");
		}
	}
}

/**
 * 两种启动线程的方法
 * 第一种：利用Thread 类实现实例启动线程
 * 
 * @author: gzb
 * @date  : 2019年9月18日 下午9:21:21
 *
 */
class PrintThread extends Thread{
	private String message;
	
	public PrintThread(String message){
		this.message=message;
	}
	@Override
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.print(message);
		}
	}
}

/**
 * 第二种：用接口Runnable创建实例类
 * 
 * @author: gzb
 * @date  : 2019年9月18日 下午9:28:25
 *
 */
class Printer implements Runnable{
	private String message;
	public Printer(String message){
		this.message=message;
	}

	@Override
	public void run() {
		for(int i=0;i<10000;i++){
			System.out.print(message);
		}
	}
	
}

/**
 * 利用synchronized实现同步方法
 * 1、线程A若是在执行deposit，这个类的所有synchronized块都被锁住，不允许其他线程进入。
 * 2、非synchronized代码，其他线程可以操作。
 * @author: gzb
 * @date  : 2019年9月18日 下午11:16:01
 *
 */
class Bank{
	private int money;
	private String name;
	public Bank(String name,int money){
		this.money=money;
		this.name=name;
	}
	
	//存款
	public synchronized void deposit(int m){
		money+=m;
		
	}
	//取款
	public synchronized boolean withdraw(int m){
		if(money>=m){
			money-=m;
			return true;
		}else {
			return false;
		}
	}
	
	public String getName(){
		return name;
	}
}

/**
 * 
 * 
 * @author: gzb
 * @date  : 2019年9月18日 下午11:38:07
 *
 */
class Gate{
	private int counter=0;
	private String name="Nobody";
	private String address="Nowhere";
	
	public void pass(String name,String address){
		this.counter++;
		this.name=name;
		this.address=address;
		check();
	}
	
	@Override
	public String toString(){
		return "No." + counter + ": " + name + ", " +address;
	}
	
	private void check(){
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("***** BROKEN *****" +toString());
		}
	}
}
/**
 * 
 * 
 * @author: gzb
 * @date  : 2019年9月18日 下午11:44:03
 *
 */
class UserThread extends Thread{
	private final Gate gate;//final 字段要初始化
	private final String myname;
	private final String myaddress;
	public UserThread(Gate gate,String myname,String myaddress){
		this.gate=gate;
		this.myname=myname;
		this.myaddress=myaddress;
	}
	
	public void run(){
		System.out.println(myname + " BEGIN");
		while(true){
			gate.pass(myname, myaddress);
		}
	}
}





