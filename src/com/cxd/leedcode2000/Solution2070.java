package com.cxd.leedcode2000;

import org.omg.CORBA.ARG_OUT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 *
 * 2070. 每一个查询的最大美丽值
 *
 * 给你一个二维整数数组items，其中items[i] = [pricei, beautyi]分别表示每一个物品的 价格和 美丽值。
 *
 * 同时给你一个下标从 0开始的整数数组queries。对于每个查询queries[j]，你想求出价格小于等于queries[j]的物品中，最大的美丽值是多少。如果不存在符合条件的物品，那么查询的结果为0。
 *
 * 请你返回一个长度与 queries相同的数组answer，其中answer[j]是第j个查询的答案。
 *
 * 示例 1：
 *
 * 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
 * 输出：[2,4,5,5,6,6]
 * 解释：
 * - queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
 * - queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
 *   它们中的最大美丽值为 4 。
 * - queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
 *   它们中的最大美丽值为 5 。
 * - queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
 *   所以，答案为所有物品中的最大美丽值，为 6 。
 * 示例 2：
 *
 * 输入：items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
 * 输出：[4]
 * 解释：
 * 每个物品的价格均为 1 ，所以我们选择最大美丽值 4 。
 * 注意，多个物品可能有相同的价格和美丽值。
 * 示例 3：
 *
 * 输入：items = [[10,1000]], queries = [5]
 * 输出：[0]
 * 解释：
 * 没有物品的价格小于等于 5 ，所以没有物品可以选择。
 * 因此，查询的结果为 0 。
 *
 * 提示：
 *
 * 1 <= items.length, queries.length <= 105
 * items[i].length == 2
 * 1 <= pricei, beautyi, queries[j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-beautiful-item-for-each-query
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution2070 {
    public static void main(String[] args) {
        int[][] items = new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = new int[]{1,2,3,4,5,6};
        System.out.println(items.length);

        System.out.println(Arrays.toString(maximumBeauty(items,queries)));
    }
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        int value = 0;
        int[] result = new int[queries.length];
        /*for (int i = 0; i < items.length; i++) {
            key = items[i][0];
            value = items[i][1];
            if (map.containsKey(key)) {
                if (map.get(key) < value) {
                    map.put(key, value);
                }
            } else {
                map.put(key, value);
            }
        }*/
        for (int i = 0; i < queries.length; i++) {
            int temp = 0;
            /*for(Map.Entry<Integer, Integer> entries : map.entrySet()) {
                if (queries[i] >= entries.getKey() && temp < entries.getValue()) {
                    temp = entries.getValue();
                }
            }*/
            for (int j = 0; j < items.length; j++) {
                if (queries[i] >= items[j][0] && temp < items[j][1]) {
                    temp = items[j][1];
                }
            }
            result[i] = temp;
        }

        return result;
    }
}
