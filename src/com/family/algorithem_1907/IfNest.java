package com.family.algorithem_1907;

import javax.swing.JOptionPane;

public class IfNest {
	public static void main(String[] args) {
        String entryData="";
        entryData=JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
        int N;
        N=0;
        try {
            N=Integer.parseInt(entryData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        entryData=(N>90?"A ":(N>=60?"B ":"C "));
        System.out.println(entryData);
    }
}
