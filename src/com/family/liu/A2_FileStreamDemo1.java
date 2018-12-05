package com.family.liu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本类举例流在项目中的应用。
 * @author hp
 *
 */
public class A2_FileStreamDemo1 {
	
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		String src="D:\\sanxia.dmp";
		String deString="D:\\sanxia_复制.dmp";
		
		testFileInputOutputStream(src,deString);
		
		long end=System.currentTimeMillis();
		
		System.out.println("本次复制花费了时间为："+(end-start));
	}
	
	/**
	 * 确保使用try/catch,finally中关闭流
	 * 本例不适应中文
	 */
	private static void inputStreamDemo1() {
	    // 创建一个FileInputStream类的对象
        FileInputStream fis = null;
        try {
            // 1.创建一个File类的对象。
            File file = new File("d:/hello.txt");
            fis = new FileInputStream(file);
            // 3.调用FileInputStream的方法，实现file文件的读取。
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭相应的流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * 应用inputStreamReader读取解决乱码问题
	 */
	private static void inputStreamDemo2() {
		FileInputStream fis =null;
		try {
            fis = new FileInputStream("d:/hello.txt");
            InputStreamReader reader = new InputStreamReader(fis,"GBK"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * 实现一个文件的复制
	 */
	// 从硬盘读取一个文件，并写入到另一个位置。（相当于文件的复制）
    public static void testFileInputOutputStream(String src,String dsec) {
        // 1.提供读入、写出的文件
        File file1 = new File(src);
        File file2 = new File(dsec);
        // 2.提供相应的流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            // 3.实现文件的复制
            byte[] b = new byte[20];
            int len;
            while ((len = fis.read(b)) != -1) {
                // fos.write(b);//错误的写法两种： fos.write(b,0,b.length);
                fos.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}














