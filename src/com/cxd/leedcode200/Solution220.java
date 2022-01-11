package com.cxd.leedcode200;

import java.util.Arrays;

/**
 * @author Administrator
 *
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution220 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,4,5,8};
//        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            // 确定起始区域
            int j = (i > k ? (i - k): 0);
            for (; (j <= k + i) && j < len; j++) {
                if(Math.abs(nums[i] - nums[j]) <= t && i != j) {
                    return true;
                }
            }
        }
        System.out.println(Integer.MIN_VALUE);

        return false;
    }


    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] tempNums = nums.clone();
        int[] numsLog = new int[101];
        int[] newNumbers = new int[nums.length];
        Arrays.sort(tempNums);
        for (int i = 1; i < tempNums.length; i++) {
            if(numsLog[tempNums[i]] > 0) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < tempNums.length; j++) {
                if(tempNums[i] > tempNums[j]) {
                    count ++;
                } else {
                    break;
                }
            }
            numsLog[tempNums[i]] = count;
        }

        for (int i = 0; i < nums.length; i++) {
            newNumbers[i] = numsLog[nums[i]];
        }
        return newNumbers;
    }
}


