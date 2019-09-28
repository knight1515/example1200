<<<<<<< HEAD
package com.family.algorithem_1908;

import java.util.ArrayList;

/**
 * •3. 数组中重复的数字
 * •4. 二维数组中的查找
 * •5. 替换空格
 * @author: gzb
 * @date  : 2019年8月16日 下午3:35:50
 *
 */
public class SwordOfficeDemo1 {
    
    public static void main(String[] args) {
        SwordOfficeDemo1 so=new SwordOfficeDemo1();
        
        //调用三个方法
//        int[] nums={3, 0, 1, 4, 4, 5};
//        int[] duplication=new int[1];
//        so.duplicate(nums,6,duplication);
//        System.out.println("重复的数据是："+duplication[0]);
        
        StringBuffer sb=new StringBuffer("ni kjf  khs ");
        String replaceSpace = so.replaceSpace(sb);
        System.out.println(replaceSpace);
    }
    /**
     * •3. 数组中重复的数字
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 要求：要求时间复杂度 O(N)，空间复杂度 O(1)。
     * @author: gzb
     * @date  : 2019年8月16日 下午4:08:06
     * @param nums 需要检测的
     * @param lenght 数组的长度
     * @param duplication 副本数组，重复的数组放里面
     * @return
     */
    public boolean duplicate(int[] nums,int lenght,int[] duplication) {
        if (nums==null || lenght<=0) {
            return false;
        }
        for(int i=0;i<lenght;i++) {
            //把i位置的数移位为i，
            while(nums[i] != i) {
                //如果移位的时候发现i位置和nums[i]相同，就找到了相同的值。
                if (nums[i] ==nums[nums[i]]) {
                    duplication[0]=nums[i];
                    return true;
                }
                //不相同的，改变位置，把i中的数据，放到对应的排序位置。
                swap(nums, i, nums[i]);
            }
        }
        
        return false;
    }
    /**
     * 移位
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午4:16:27
     * @param nums 需要检测的数组
     * @param i 实际到的数组位置
     * @param j nums[i]
     */
    private void swap(int[] nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    /**
     * •4. 二维数组中的查找
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午4:53:35
     * @param target 查找的数据
     * @param matrix 两维数组
     * @return
     */
    public boolean Find(int target,int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length ==0) {
            return false;
        }
        int rows = matrix.length, cols=matrix[0].length;
        int r=0,c=cols-1;//从右上角开始
        while(r<=rows-1 && c>=0) {
            if (target==matrix[r][c]) {
                return true;
            }
            else if(target >matrix[r][c]) {
                r++;
            }else {
                c--;
            }
            return false;
        }
        return false;
    }
    
    /**
     * 5. 替换空格
     * 将一个字符串中的空格替换成 "%20"。
        Input:
        "A B"
        
        Output:
        "A%20B"
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午5:27:54
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int P1=str.length()-1;//P1等于长度值
        //有n个空值，就在后面加2*n个随意字符
        for(int i=0;i<=P1;i++) {
            if (str.charAt(i)==' ') {
                str.append("  ");
            }
        }
        int P2=str.length()-1;//P2等于改造后的长度值
        //迭代所有值，遇到空是依次复制P2为（%20）倒序
        while(P1>=0&&P2>P1) {
            char c=str.charAt(P1--);
            if (c==' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            }else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
    
    
    

    
}





    














=======
package com.family.algorithem_1908;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.jasper.xmlparser.TreeNode;
import org.junit.Test;

/**
 * •3. 数组中重复的数字
 * •4. 二维数组中的查找
 * •5. 替换空格
 * @author: gzb
 * @date  : 2019年8月16日 下午3:35:50
 *
 */
public class SwordOfficeDemo1 {
    
    public static void main(String[] args) {
        SwordOfficeDemo1 so=new SwordOfficeDemo1();
        
        //调用三个方法
//        int[] nums={3, 0, 1, 4, 4, 5};
//        int[] duplication=new int[1];
//        so.duplicate(nums,6,duplication);
//        System.out.println("重复的数据是："+duplication[0]);
        
        StringBuffer sb=new StringBuffer("ni kjf  khs ");
        String replaceSpace = so.replaceSpace(sb);
        System.out.println(replaceSpace);
    }
    /**
     * •3. 数组中重复的数字
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 要求：要求时间复杂度 O(N)，空间复杂度 O(1)。
     * @author: gzb
     * @date  : 2019年8月16日 下午4:08:06
     * @param nums 需要检测的
     * @param lenght 数组的长度
     * @param duplication 副本数组，重复的数组放里面
     * @return
     */
    public boolean duplicate(int[] nums,int lenght,int[] duplication) {
        if (nums==null || lenght<=0) {
            return false;
        }
        for(int i=0;i<lenght;i++) {
            //把i位置的数移位为i，
            while(nums[i] != i) {
                //如果移位的时候发现i位置和nums[i]相同，就找到了相同的值。
                if (nums[i] ==nums[nums[i]]) {
                    duplication[0]=nums[i];
                    return true;
                }
                //不相同的，改变位置，把i中的数据，放到对应的排序位置。
                swap(nums, i, nums[i]);
            }
        }
        
        return false;
    }
    /**
     * 移位
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午4:16:27
     * @param nums 需要检测的数组
     * @param i 实际到的数组位置
     * @param j nums[i]
     */
    private void swap(int[] nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    /**
     * •4. 二维数组中的查找
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午4:53:35
     * @param target 查找的数据
     * @param matrix 两维数组
     * @return
     */
    public boolean Find(int target,int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length ==0) {
            return false;
        }
        int rows = matrix.length, cols=matrix[0].length;
        int r=0,c=cols-1;//从右上角开始
        while(r<=rows-1 && c>=0) {
            if (target==matrix[r][c]) {
                return true;
            }
            else if(target >matrix[r][c]) {
                r++;
            }else {
                c--;
            }
            return false;
        }
        return false;
    }
    
    /**
     * 5. 替换空格
     * 将一个字符串中的空格替换成 "%20"。
        Input:
        "A B"
        
        Output:
        "A%20B"
     * 
     * @author: gzb
     * @date  : 2019年8月16日 下午5:27:54
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int P1=str.length()-1;//P1等于长度值
        //有n个空值，就在后面加2*n个随意字符
        for(int i=0;i<=P1;i++) {
            if (str.charAt(i)==' ') {
                str.append("  ");
            }
        }
        int P2=str.length()-1;//P2等于改造后的长度值
        //迭代所有值，遇到空是依次复制P2为（%20）倒序
        while(P1>=0&&P2>P1) {
            char c=str.charAt(P1--);
            if (c==' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            }else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
    
    /**
     * 9. 用两个栈实现队列
     * 栈是先进后出，队列是先进先出。
     * 两个栈的颠倒能实现第二个栈弹出pop的是先进的。
     */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();
    
    //用栈in来完成队列的push功能
    public void pust(int node) {
        in.push(node);
    }
    
    //用out实现pop功能
    public int pop() throws Exception{
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty!");
        }
        return out.pop();
    }
    //--------------------------------9. 用两个栈实现队列-结束---------------------------------
    
    /**
     * 10.1 斐波那契数列的第n项
     * 
     * @author: gzb
     * @date  : 2019年9月24日 下午2:11:57
     */
    @Test
    public void testFibonacci() {
        SwordOfficeDemo1 so = new SwordOfficeDemo1();
        int fibonacci = so.Fibonacci(10);
        System.out.println(fibonacci);
    }
    /**
     * 如果使用递归求解，会重复计算一些子问题。例如，计算 f(4) 需要计算 f(3) 和 f(2)，计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了。
     * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
     * 
     * @author: gzb
     * @date  : 2019年9月24日 下午2:13:12
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n<=1) {
            return n;
        }
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i=2;i<=n;i++) {
            fib[i] = fib[i-1] +fib[i-2];
        }
        return fib[n];
    }
    
    /**
     * 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
     * 
     * @author: gzb
     * @date  : 2019年9月24日 下午2:30:49
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n<=1) {
            return n;
        }
        int pre2=0,pre1=1;
        int fib=0;
        for(int i=2;i<=n;i++) {
            fib = pre1+pre2;
            pre1=pre2;
            pre2=fib;
        }
        return fib;
    }
    //--------------10.1 斐波那契数列的第n项——结束----------------------
    
    /**
     * 11. 在旋转数组中获得最小数字,
     * 必须是排序后的数据，部分（小于一半）最左边的值挪到了最右边，才适用这种算法
     * 
     * @author: gzb
     * @date  : 2019年9月24日 下午4:38:18
     */
    @Test
    public void testMinNumberInRotateArray() {
        SwordOfficeDemo1 so = new SwordOfficeDemo1();
//        int[] nums = new int[4];
        int[] nums = {2,4,1,10,4,2,23,5};
        int minNumberInRotateArray = so.minNumberInRotateArray(nums);
        System.out.println("return:"+minNumberInRotateArray);
    }
    
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
    //要是存在相同的数字，就要多一步判断

    //------------------------11. 在旋转数组中获得最小数字,_结束--------------------
    
}


/**
 * 10.1 斐波那契数列的第n项
 * 由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
 * 
 * @author: gzb
 * @date  : 2019年9月24日 下午2:40:26
 *
 */
class Solution {

    private int[] fib = new int[40];

    public Solution() {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
    }

    public int Fibonacci(int n) {
        return fib[n];
    }
}



















    














>>>>>>> 3054aaf41a0d73d0703d76d290205d28fb6d929c
