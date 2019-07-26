package com.family.algorithem_1907;

public class JiuJiu {
    public static void main(String[] args) {
        JiuJiu jj=new JiuJiu();
        jj.getJiu3();
                
    }
    
    private void getJiu() {
        int i=0;
        int j=0;
        for(i=1;i<=9;i++) {
            for(j=1;j<=i;j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
    
    private void getJiu2() {
        int i=0;
        int j=0;
        for(i=1;i<=9;i++) {
            for(j=9;j>=i;j--) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
                
    }
    
    private void getJiu3() {
        int i=0;
        int j=0;
        for (i=1;i<=9;i++) {
            for(j=i;j<=9;j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
