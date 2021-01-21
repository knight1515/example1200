package com.family.algorithm_2005;

import org.junit.Test;

import java.util.Arrays;

public class CsNotes {

    @Test
    public void testRectCover() {
        System.out.println(RectCover(4));
    }

    /**
     * 10.2
     * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
     *
     * 找规律，找到规律就规划逻辑。
     * @param n
     * @return
     */
    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2;
        int result = 0;
        for (int i = 3; i <= n-1; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    @Test
    public void testJumpFloor() {
        System.out.println(jumpFloor(3));
    }

    /**
     * 只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 阶段依赖之前算法
     * @param n
     * @return
     */
    public int jumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i < n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    @Test
    public void testJumpFloorII() {
        System.out.println(jumpFloorII(5));
    }

    /**
     * 只青蛙一次可以跳上 1 级台阶，也可以跳上 n 级
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i ++){
            for (int j = 0; i < i; j++){
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }


    /**
     * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，
     * 每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
     */
    @Test
    public void testMovingCount() {
        System.out.println(movingCount(3, 80, 80));
    }

    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    /**
     * @param threshold k
     * @param rows 二维数组行数
     * @param cols 二维数组列数
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }
    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold) {
            return;
        }
        cnt++;
        for (int[] n : next) {
            dfs(marked, r + n[0], c + n[1]);
        }
    }
    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }

    @Test
    public void testIntegerBreak() {
        System.out.println(integerBreak(5));
    }

    /**
     * 14. 剪绳子
     * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if(n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3 --;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * (int) (Math.pow(2, timesOf2)));
    }

    /**
     * 15. 二进制中 1 的个数
     * O(n)
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
