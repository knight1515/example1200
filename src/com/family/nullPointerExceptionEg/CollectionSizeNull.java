package com.family.nullPointerExceptionEg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 
 * @author: gzb
 * @date  : 2019年8月1日 下午5:52:52
 */
public class CollectionSizeNull {

    public static void main(String[] args) {
        CollectionSizeNull cs=new CollectionSizeNull();
        cs.ObjectToString();
    }
    
    /**
     * 1) 从已知的String对象中调用equals()和equalsIgnoreCase()方法，而非未知对象。
                    总是从已知的非空String对象中调用equals()方法。因为equals()方法是对称的，调用a.equals(b)和调用b.equals(a)是完全相同的，
                    这也是为什么程序员对于对象a和b这么不上心。如果调用者是空指针，这种调用可能导致一个空指针异常
     * @author: gzb
     * @date  : 2019年8月2日 上午9:59:11
     */
    private void checkStringByEquals() {
      Object unknownObject = null;
        
      //错误方式 – 可能导致 NullPointerException
      if(unknownObject.equals("knownObject")){
        System.err.println("This may result in NullPointerException if unknownObject is null");
      }
       
      //正确方式 - 即便 unknownObject是null也能避免NullPointerException
      if("knownObject".equals(unknownObject)){
        System.err.println("better coding avoided NullPointerException");
      }
    }
    
    /**
     * 因为调用null对象的toString()会抛出空指针异常，如果我们能够使用valueOf()获得相同的值，那宁愿使用valueOf()，
     * 传递一个null给valueOf()将会返回“null”，尤其是在那些包装类，像Integer、Float、Double和BigDecimal。
     * @author: gzb
     * @date  : 2019年8月2日 上午10:00:23
     */
    private void ObjectToString() {
        Student student=new Student();
        System.out.println(String.valueOf(student.getName())); //不会抛出空指针异常
        String aString  = String.valueOf(student.getName());
        if("null".equals(aString)) {
            System.out.println("nih");
        }
//        System.out.println(student.getName().toString()); //抛出 "Exception in thread "main" java.lang.NullPointerException"
    }
    
    /**
     * 其中最常用的一个的是Apache commons 中的StringUtils。你可以使用StringUtils.isBlank()，isNumeric()，isWhiteSpace()以及其他的工具方法而不用担心空指针异常。
     * @author: gzb
     * @date  : 2019年8月2日 上午10:00:49
     */
    private void checkStringUtils() {
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isNumeric(null));
        System.out.println(StringUtils.isAllUpperCase(null));
    }
}
