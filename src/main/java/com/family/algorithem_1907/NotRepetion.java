package com.family.algorithem_1907;

public class NotRepetion {
    public static void main(String[] args) {
        NotRepetion nr=new NotRepetion();
        int[] arr= {1,2,3,4};
        nr.getNotRepetition(arr);
//        nr.getNotRepetition2();
    }
    private void getNotRepetition(int[] arr) {
        int sum=0;
        int num=1;
//        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<3;j++) {
                if ((arr.length-j)!=0) {
                    num=num*(arr.length-j);
                    sum=1;
                }
            }
//        }
        if (sum==1) {
            System.out.println(num);
        }
    }
    
    private void getNotRepetition2() {
        int i=0;
        int j=0;
        int k=0;
        int t=0;
        for(i=1;i<=4;i++)
            for(j=1;j<=4;j++)
                for(k=1;k<=4;k++)
                    if(i!=j && j!=k && i!=k)
                    {t+=1;
                        System.out.println(i*100+j*10+k);
                     }  
        System.out.println (t);
        }

}
