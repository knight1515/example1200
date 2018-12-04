package com.family.liu;
/**
 * 字节流和字符流的初步认识
 * 实际上字节流在操作时本身不会用到缓冲区（内存），是文件本身直接操作的，而字符流在操作时使用了缓冲区，通过缓冲区再操作文件。
 * 
 * 
 * 1.Java的字节流
    InputStream是所有字节输入流的祖先，而OutputStream是所有字节输出流的祖先。
   2.Java的字符流
  	Reader是所有读取字符串输入流的祖先，而writer是所有输出字符串的祖先。
  	
   3、字节流和字符流那个好。
  	使用字节流更好。
	在回答之前，先为读者讲解这样的一个概念，所有的文件在硬盘或在传输时都是以字节的方式进行的，包括图片等都是按字节的方式存储的，
	而字符是只有在内存中才会形成，所以在开发中，字节流使用较为广泛。
 * @author hp
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class A_streamWriter1 {

	public static void main(String[] args) throws IOException {
		writerDemo2();
	}

	/**
	 * 字节流测试 此时没有关闭字节流操作，
	 * 但是文件中也依然存在了输出的内容，证明字节流是直接操作文件本身的。而下面继续使用字符流完成，再观察效果。
	 * 
	 * @throws IOException
	 */
	private static void OutputStreamDemo1() throws IOException {
		// 第1步：使用File类找到一个文件
		File f = new File("d:" + File.separator + "test.txt"); // 声明File 对象
		// 第2步：通过子类实例化父类对象
		OutputStream out = null;
		// 准备好一个输出的对象
		out = new FileOutputStream(f);
		// 通过对象多态性进行实例化
		// 第3步：进行写操作
		String str = "Hello World!!!";
		// 准备一个字符串
		byte b[] = str.getBytes();
		// 字符串转byte数组
		out.write(b);
		// 将内容输出
		// 第4步：关闭输出流
		// out.close();
		// 此时没有关闭
	}

	/**
	 * 字符流测试
	 * 
	 * @throws IOException
	 * 
	 *             程序运行后会发现文件中没有任何内容，这是因为字符流操作时使用了缓冲区，
	 *             而在关闭字符流时会强制性地将缓冲区中的内容进行输出，但是如果程序没有关闭，
	 *             则缓冲区中的内容是无法输出的，所以得出结论：字符流使用了缓冲区，而字节流没有使用缓冲区。
	 */
	private static void writerDemo1() throws IOException {
		// 第1步：使用File类找到一个文件
		File f = new File("d:" + File.separator + "test.txt");// 声明File 对象
		// 第2步：通过子类实例化父类对象
		Writer out = null;
		// 准备好一个输出的对象
		out = new FileWriter(f);
		// 通过对象多态性进行实例化
		// 第3步：进行写操作
		String str = "Hello World!!!";
		// 准备一个字符串
		out.write(str);
		// 将内容输出
		// 第4步：关闭输出流
		// out.close();
		// 此时没有关闭
	}

	/**
	 * 字符流强制输出缓冲区内容 flush()输出
	 * 
	 * 
	 * @throws IOException
	 */
	private static void writerDemo2() throws IOException {
		// 第1步：使用File类找到一个文件
		File f = new File("d:" + File.separator + "test.txt");// 声明File 对象
		// 第2步：通过子类实例化父类对象
		Writer out = null;
		// 准备好一个输出的对象
		out = new FileWriter(f);
		// 通过对象多态性进行实例化
		// 第3步：进行写操作
		String str = "Hello World!!!";
		// 准备一个字符串
		out.write(str);
		// 将内容输出
		out.flush();
		// 强制性清空缓冲区中的内容
		// 第4步：关闭输出流
		// out.close();
		// 此时没有关闭
	}

}
