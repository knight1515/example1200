package com.family.algorithem_1907;

public class CommonDivisorAndMultiple {
    public static void main(String args[]) {
        commonDivisor(4, 8);
//         int a=21; int b=28;
//         int c = gcd(a, b);
//         System.out.println( "最小公倍数： " + a * b / c + "\n最大公约数： " + c);
    }
    /**
     * 碾除法获得最大公约数
     * @param M
     * @param N
     * @return
     */
    static int commonDivisor(int M, int N) {
        if (N < 0 || M < 0) {
            System.out.println("ERROR! ");
            return -1;
        }
        if (N == 0) {
            System.out.println("the   biggest   common   divisor   is   : " + M);
            return M;
        }
        return commonDivisor(N, M % N);
    }
    
    // 下面的方法是求出最大公约数
    public static int gcd(int m, int n) {
        while (true) {
            if ((m = m % n) == 0)
                return n;
            if ((n = n % m) == 0)
                return m;
        }
    }
}
