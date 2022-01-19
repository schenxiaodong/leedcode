package com.cxd.algorithm.dataStructure.sortedArrayDuplicates;

/**
 * @author Administrator
 *
 * 删除排序数组中的重复项
 * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 不能使用额外的数组空间，必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * 例：输入：[0,1,2,2,3,3,4]
 *    输出：5
 */
public class SortedArrayDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 1, 2, 2, 3, 3, 4}));
    }

    private static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

}
