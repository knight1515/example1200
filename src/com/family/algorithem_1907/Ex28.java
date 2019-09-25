package com.family.algorithem_1907;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi2.hssf.record.formula.functions.Int;

public class Ex28 {
    public static void main(String[] args) {
        Ex28 e=new Ex28();
        e.calculateOrder();
    }
    /**
     * Arrays.sort 的应用。
     */
    private void calculateOrder() {
        int[] arr= new int[11];
        Random r=new Random();
        for(int i=0;i<10;i++) {
            arr[i] =r.nextInt(100)+1;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] +"\t");
        }
        System.out.print("\nPlease Input a int number: ");
        Scanner sc=new Scanner(System.in);
        arr[10]=sc.nextInt();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+"\t");
        }
    }
    
}

















