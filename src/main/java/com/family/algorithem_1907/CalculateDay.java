package com.family.algorithem_1907;

import java.util.Scanner;

public class CalculateDay {
    public static void main(String[] args) {
        CalculateDay cd =new CalculateDay();
        cd.getDay();
    }
    /**
     * 若是日期输入错误没有校验，不好。
     */
    private void getDay() {
        int day =0;
        int month=0;
        int year=0;
        int sum=0;
        int leap;
        System.out.println("请输入年，月，日\n");
        Scanner input=new Scanner(System.in);
        year=input.nextInt();
        month=input.nextInt();
        day=input.nextInt();
        switch (month) {
        case 1:
            sum=0;
            break;
        case 2:
            sum=31;
            break;
        case 3:
            sum=59;
            break;
        case 4:
            sum=90;
            break;
        case 5:
            sum=120;
            break;
        case 6:
            sum=151;
            break;
        case 7:
            sum=181;
            break;
        case 8:
            sum=212;
            break;
        case 9:
            sum=243;
            break;
        case 10:
            sum=273;
            break;
        case 11:
            sum=304;
            break;
        case 12:
            sum=334;
            break;

        default:
            System.out.println("month error");
            break;
        }
        sum=sum+day;
        if (year%400==0||(year%4==0&&year%100!=0)) {
            leap=1;
        }else {
            leap=0;
        }
        if (leap==1 && month>2) {
            sum++;
        }
        System.out.println("It is the day:"+sum);
    }
}
