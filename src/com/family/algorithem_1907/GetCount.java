package com.family.algorithem_1907;

import java.util.Scanner;

public class GetCount {
    
    public static void main(String[] args) {
       
    }
    
    
    private void getNumber() {
        String chineseRegex="[\u4e00-\u9fa5]";
        String chatacterRegex="[a-zA-Z]";
        String numberRegex="[\\d]";
        String blankRegex="[\\s]";
        
        System.out.println("请你输入字符串：");
//        Scanner scan=new Scanner(System.in);
//        String str=scan.next();
        String str="fdsaf342  sfds科技大厦看见。，哈哈";

        int chineseCount=0;
        int chatacterCount=0;
        int numberCount=0;
        int blankCount=0;
        char[] arrChar=str.toCharArray();
        String[] arrStr=new String[arrChar.length];
        for(int i=0;i<arrChar.length;i++) {
            arrStr[i]=String.valueOf(arrChar[i]);
        }
        for(String i:arrStr) {
            if (i.matches(chineseRegex)) {
                chineseCount++;
            }
            if (i.matches(chatacterRegex)) {
                chatacterCount++;
            }
            if (i.matches(numberRegex)) {
                numberCount++;
            }
            if (i.matches(blankRegex)) {
                blankCount++;
            }
        }
        
        System.out.println("汉字的个数："+chineseCount);
        System.err.println("数字的个数："+numberCount);
        System.out.println("字母的个数："+chatacterCount);
        System.err.println("空格的个数："+blankCount);
        int elseCount=arrStr.length-(chineseCount+chatacterCount+numberCount+blankCount);
        System.out.println("其他的字符个数为："+elseCount);
    }
    
    private static  void getStrNumber() {
        String chineseRegex="[\\u4e00-\\u9fa5]";
        String chatacterRegex="[a-zA-Z]";
        String numberRegex="[\\d]";
        String blankRegex="[\\s]";
        int chineseCount=0;
        int chatacterCount=0;
        int numberCount=0;
        int blankCount=0;
        
        String str="";
        char[] arrChar=str.toCharArray();
        String[] arrStr=new String[arrChar.length];
        for (int i = 0; i < arrChar.length; i++) {
            arrStr[i] = String.valueOf(arrChar[i]);
        }
        
        for(String i:arrStr) {
            if (i.matches(chineseRegex)) {
                chineseCount++;
            }
            if (i.matches(chatacterRegex)) {
                chatacterCount++;
            }
            if (i.matches(blankRegex)) {
                blankCount++;
            }
            if (i.matches(numberRegex)) {
                numberCount++;
            }
        }
        System.out.println("汉字的数量："+chineseCount);
        System.out.println("数字的数量："+numberCount);
        System.out.println("空格的数量："+blankCount);
        System.out.println("字母的数量："+chatacterCount);
        int elesCount=arrStr.length-(chineseCount+chatacterCount+blankCount+numberCount);
        System.out.println("其他字符的数量："+elesCount);
    }
}






















