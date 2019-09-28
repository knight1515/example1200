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





    














