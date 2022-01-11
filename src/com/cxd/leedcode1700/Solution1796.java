package com.cxd.leedcode1700;

import java.lang.annotation.ElementType;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author Administrator
 *
 * 1796. 字符串中第二大的数字
 *
 * https://leetcode-cn.com/problems/second-largest-digit-in-a-string/
 */
public class Solution1796 {

    public static void main(String[] args) {
        String s = "dfa12321afd";
        System.out.println(secondHighest(s));
    }

    /**
     * 方式三， 定义一个10空间大小的int数组，如果出现对应的数字，数组值就改为1
     * @param s
     * @return
     */
    public static int secondHighest(String s) {
        int[] ints = new int[10];
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) - '0';
            if(temp < 10) {
                ints[temp] = 1;
            }
        }
        int i = 9;
        temp = 0;
        /**
         * 倒序遍历遍历，temp = 2 指遇到第二大的数字了
         */
        for (; temp != 2 && i >= 0; i--) {
            temp += ints[i];
        }

        return temp != 2 ? i: i +1 ;
    }

    /**
     * 方式2 不简便
     * @param s
     * @return
     */
//    public static int secondHighest(String s) {
//        char[] chars = s.toCharArray();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int temp = 0;
//        for (int i = 0; i < chars.length; i++) {
//            temp = chars[i] - '0';
//            if(temp < 10 && !arrayList.contains(temp)) {
//                arrayList.add(temp);
//            }
//        }
//
//        if(arrayList.size() > 1) {
//            arrayList.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            });
//            return arrayList.get(1);
//        }
//        return -1;
//    }

    /**
     * @param s
     * @return int
     * 解题方法 1 时间消耗大，内存消耗大
     * 使用Set的特性(Set 里面不允许有重复的元素) 来存储所有的 数字
     * 然后对数字排序，找出倒数第二个即可
     */
//    public static int secondHighest(String s) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
//                int i1 = Integer.parseInt(String.valueOf(s.charAt(i)));
//                set.add(i1);
//            }
//        }
//
//        Object[] objects = set.toArray();
//        if(objects.length > 1) {
//            Arrays.sort(objects);
//            return (int)objects[objects.length - 2];
//        } else {
//            return -1;
//        }
//
//    }
}
