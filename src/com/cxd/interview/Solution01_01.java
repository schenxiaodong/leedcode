package com.cxd.interview;

/**
 * @author Administrator
 *
 * 面试题 01.01. 判定字符是否唯一
 *
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class Solution01_01 {
    public static void main(String[] args) {
        String s = "leedcode";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String astr) {
        int[] ints = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int c = astr.charAt(i) - 'a';
            if(ints[c] == 0) {
                ints[c] = 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
