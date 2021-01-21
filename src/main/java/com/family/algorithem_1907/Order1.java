package com.family.algorithem_1907;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order1 {
    
    public static void main(String[] args) {
        Order1 order1=new Order1();
        order1.getOrderList();
    }
    
    private void getOrderList() {
        List list = new ArrayList();
        int i=0;
        int j=0;
        int k=0;
        int x=0;
        System.out.print("请输入三个数\n");
        Scanner sc= new Scanner(System.in);
        i=sc.nextInt();
        j=sc.nextInt();
        k=sc.nextInt();
        if (i>j) {
            x=i;
            i=j;
            j=x;
        }
        if (j>k) {
            x=j;
            j=k;
            k=x;
        }
        if (i>j) {
            x=i;
            i=j;
            j=x;
        }
        System.out.println(i+","+j+","+k);
    }
}
