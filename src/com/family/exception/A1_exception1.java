package com.family.exception;

import org.w3c.dom.events.EventException;

/**
 * exception处理就是捕获并进行处理。
 * @author hp
 *
 */
public class A1_exception1 {
	
	/**
	 * 1、常见异常
	 * 
	 * ArithmeticException——由于除数为0引起的异常； 
		ArrayStoreException——由于数组存储空间不够引起的异常； 
		ClassCastException—一当把一个对象归为某个类，但实际上此对象并不是由这个类 创建的，也不是其子类创建的，则会引起异常； 
		IllegalMonitorStateException——监控器状态出错引起的异常； 
		NegativeArraySizeException—一数组长度是负数，则产生异常； 
		NullPointerException—一程序试图访问一个空的数组中的元素或访问空的对象中的 方法或变量时产生异常； 
		OutofMemoryException——用new语句创建对象时，如系统无法为其分配内存空 间则产生异常； 
		SecurityException——由于访问了不应访问的指针，使安全性出问题而引起异常； 
		IndexOutOfBoundsExcention——由于数组下标越界或字符串访问越界引起异常； 
		IOException——由于文件未找到、未打开或者I/O操作不能进行而引起异常； 
		ClassNotFoundException——未找到指定名字的类或接口引起异常； 
		CloneNotSupportedException——一程序中的一个对象引用Object类的clone方法，但 此对象并没有连接Cloneable接口，从而引起异常； 
		InterruptedException—一当一个线程处于等待状态时，另一个线程中断此线程，从 而引起异常，有关线程的内容，将在下一章讲述； 
		NoSuchMethodException一所调用的方法未找到，引起异常； 
		Illega1AccessExcePtion—一试图访问一个非public方法； 
		StringIndexOutOfBoundsException——访问字符串序号越界，引起异常； 
		ArrayIdexOutOfBoundsException—一访问数组元素下标越界，引起异常； 
		NumberFormatException——字符的UTF代码数据格式有错引起异常； 
		IllegalThreadException—一线程调用某个方法而所处状态不适当，引起异常； 
		FileNotFoundException——未找到指定文件引起异常； 
		EOFException——未完成输入操作即遇文件结束引起异常。
	 * @param args
	 */
	
	public static void main(String[] args) {
        try{
            throw new A2_myException("123","自定义异常。") ;    // 抛出异常
        }catch(Exception e){
            System.out.println(e) ;
        }
	}
	
	/**
	 * 异常的的抛出：throws
	 * 抛出就是本方法不处理异常而是抛出，交给调用方法处理。
	 * 那么：谁调用本方法是就处理，或者继续抛出。
	 * 
	 * @param i
	 * @param j
	 * @return
	 * @throws Exception
	 */
    public static int throwsDemo1(int i,int j) throws Exception{   // 定义除法操作，如果有异常，则交给被调用处处理
        int temp = i / j ;  // 计算，但是此处有可能出现异常
        return temp ;
    }
	
    /**
     * 本方法自己处理异常
     * try捕获，catch处理，finally最后的代码
     * 
     * 处理一般就是打印出错误日志：e.printStackTrace()，并把错误信息传给客户端。
     * @param i
     * @param j
     * @return
     */
    public static int throwDemo1(int i,int j){   
    	int temp =0;
        try {
            temp = i / j ;  // 计算，但是此处有可能出现异常
            return temp ;
        }catch (Exception e) {
        	e.printStackTrace();
		}
        return temp ;
    }
    
    /**
     * finally将会作为异常的统一出口，不管是否出现异常都会执行finally中的语句。
     * 
     * 例如关闭流等
     * @return
     */
    private static int finallyDemo1(int i,int j) {
    	int temp =0;
        try {
            temp = i / j ;  // 计算，但是此处有可能出现异常
            return temp ;
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
			System.out.println(i);//无论是否出错误都会打印i信息
		}
        return temp ;
    }
	
    /**
     * 本方法抛出多个异常,
     * @param i
     * @param j
     * @return
     */
    private static int throwDemo2(int i,int j) {
        int temp = i / j ;  // 计算，但是此处有可能出现异常
        if (j==0) {
			throw new EventException((short) 0, null);
		}else if (j==-1) {
			throw new RuntimeException();
		}
        return temp ;
    }
    
    /**
     * 调用throwDemo2，catch顺序要先子类，再父类，不然无法处理到子类异常。而且也会报错
     * @param i
     * @param j
     * @return
     */
    private static int testThrowDemo2(int i,int j) {
    	int throwDemo2 =0;
    	try {
    		throwDemo2 = throwDemo2(1,2);
		}catch (EventException e) {
			// TODO: handle exception
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
    	return throwDemo2;
    }
    
}

/**
 * 最简单的自定义的异常
 * @author hp
 */
class MyException extends Exception{    // 自定义异常类，继承Exception类
    public MyException(String msg){
        super(msg) ;    // 调用Exception类中有一个参数的构造方法，传递错误信息
    }
};
