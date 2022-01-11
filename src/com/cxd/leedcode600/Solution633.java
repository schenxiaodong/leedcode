package com.cxd.leedcode600;

/**
 * @author Administrator
 *
 * 633. 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class Solution633 {
    public static void main(String[] args) {
        int c = 2147483644;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        if(c == 1 || c == 2 || c == 4) {
            return true;
        }
        if(c == 3) {
            return false;
        }

        int sqrtNum = (int) Math.sqrt(c) + 1;
        for (int i = 0; i <= sqrtNum; i++) {
            for (int j = i; j <= sqrtNum; j++) {
                if((i*i + j*j) == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
