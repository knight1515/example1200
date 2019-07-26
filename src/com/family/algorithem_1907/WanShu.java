package com.family.algorithem_1907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WanShu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入要获得完数的最大值");
        Integer readLine = Integer.parseInt(br.readLine());
        qiuWanShu3(readLine);
    }

    /**
     * 方法一
     * 
     * @param operateNumber
     */
    private static void qiuWanShu(int operateNumber) {
        System.out.println(operateNumber + "以内的完数有：");
        // for循环每个目标数
        for (int i = 1; i <= operateNumber; i++) {
            int sum = 0;
            // 对操作数循环获得所有因数
            for (int j = 1; j < i; j++) {
                // 获得因数
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.print(i + ",");
            }
        }
    }

    private static void qiuWanShu2(int operateNumber) {
        int s;
        for (int i = 1; i <= operateNumber; i++) {
            s = 0;
            for (int j = 1; j < i; j++)
                if (i % j == 0)
                    s = s + j;
            if (s == i) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void qiuWanShu3(int operateNumber) {
        int s;
        for (int i = 1; i <= operateNumber; i++) {
            s = 0;
            for (int j = 1; j < i; j++)
                if (i % j == 0)
                    s = s + j;
            if (s == i)
                System.out.print(i + "   ");
        }
        System.out.println();
    }
}
