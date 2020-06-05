package com.family.fileupload;

import org.junit.Test;

import java.io.*;

public class fileInput {
    @Test
    public void inputText() throws IOException {
        File file = new File("D:\\123.txt");
        //创建文件缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//        BufferedReader reader = new BufferedReader (new InputStreamReader(file));
        byte[] buf = new byte[1024];//创建字节数组，存储临时读取的数据
        int len = 0;//记录数据读取的长度
        //循环读取数据
        while((len = bis.read(buf)) != -1) { //长度为-1则读取完毕
            System.out.println(new String(buf,0,len));
        }
        bis.close(); //关闭流
    }
}
