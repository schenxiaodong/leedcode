package com.cxd.leedcode1500;

/**
 * @author Administrator
 *
 * 1535. 找出数组游戏的赢家
 *
 * https://leetcode-cn.com/problems/find-the-winner-of-an-array-game/
 */
public class Solution1535 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,5,4,6,7};
        int k = 2;

        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {
        int maxNum = arr[0];
        int flag = 0;
        if (k >= arr.length) {
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > maxNum) {
                    maxNum = arr[i];
                }
            }
        } else {
            for (int i = 1; i < arr.length; i++) {
                int temp = 0;
                if(flag == 0) {
                    temp = i - 1;
                } else {
                    temp = i - flag;
                }
                if(maxNum < arr[i] && temp < k) {
                    maxNum = arr[i];
                    flag = i;
                }
            }
        }

        return maxNum;
    }
}
