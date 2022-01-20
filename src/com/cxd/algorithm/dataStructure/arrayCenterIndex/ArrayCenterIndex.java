package com.cxd.algorithm.dataStructure.arrayCenterIndex;

import java.util.Arrays;

/**
 * @author Administrator
 *
 * 寻找数组的中心下标
 *
 * 给定一个整数数组 nums，请编写一个能够返回数组“中心下标”的方法。
 * 中心下标是数组的一个下标，其左侧返回所有原色相加的和等于右侧所有元素相加的和
 * 如果数组不存在中心下标，返回-1.如果数组有多个中心下标，应该返回最靠近左边的那一个
 * 注意：中心下标可能出现在数组的两端
 */
public class ArrayCenterIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * 如上给的数组列表为 [1, 7, 3, 6, 5, 6]
     * 中心下标应该是3，值为6
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        // 先求出数组总和
        // 方式1，利用Arrays jdk8新特性
        // int sum = Arrays.stream(nums).sum();
        // 方式2，遍历循环
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 遍历nums数组，计算左侧数组相加是否与数组总和相等
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            // 左侧元素相加
            total += nums[i];
            // 如果左侧数组相加是否与数组总和相等
            if(total == sum) {
                // 返回元素下标
                return i;
            }
            // 否则 total 减去当前元素
            sum -= nums[i];
        }
        // 如果数组不存在中心下标，返回-1
        return -1;
    }

    /**
     * 方式2
     * 遍历左侧元素，判断2倍左侧元素 + 当前元素是否等于总和
     * @param nums
     * @return
     */
    public static int pivotIndex2(int[] nums) {
        // 先求出数组总和
        // 方式1，利用Arrays jdk8新特性
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length && (2 * total) <= sum; i++) {
            // 计算 2倍左侧元素 + 当前元素是否等于总和
            int temp = 2 * total + nums[i];
            if(temp == sum) {
                // 返回元素下标
                return i;
            }
            // 左侧元素相加
            total += nums[i];
        }
        return -1;
    }
}
