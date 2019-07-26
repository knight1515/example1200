package com.family.algorithem_1907;

import java.util.ArrayList;
/**
 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。\
 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。   
 * @author hp
 *
 */
public class PingPang {
    String a,b,c;
    public static void main(String[] args) {
        String[] op = {"x","y","z"};
        ArrayList<PingPang> pingPangList=new ArrayList<>();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                for(int k=0;k<3;k++) {
                    PingPang pingPang=new PingPang(op[i], op[j], op[k]);
                    if (!pingPang.a.equals(pingPang.b)&&!pingPang.a.equals(pingPang.c)&&
                            !pingPang.a.equals("x")&&!pingPang.c.equals("x")&&!pingPang.c.equals("z")) {
                        pingPangList.add(pingPang);
                    }
                }
            }
        }
        for(Object aObject :pingPangList) {
            System.out.println(aObject);
        }
    }
    
    public PingPang(String a,String b,String c) {
        super();
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public String toString() {
        return "a的对手是"+a+","+"b的对手是"+b+","+"c的对手是"+c+"\n";
    }
}
