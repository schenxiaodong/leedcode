package com.cxd.leedcode1100;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author Administrator
 *
 * 1170. 比较字符串最小字母出现频次
 *
 * 定义一个函数f(s)，统计s 中（按字典序比较）最小字母的出现频次 ，其中 s是一个非空字符串。
 *
 * 例如，若s = "dcce"，那么f(s) = 2，因为字典序最小字母是"c"，它出现了2 次。
 *
 * 现在，给你两个字符串数组待查表queries和词汇表words 。对于每次查询queries[i] ，需统计 words 中满足f(queries[i])< f(W)的 词的数目 ，W 表示词汇表words中的每个词。
 *
 * 请你返回一个整数数组answer作为答案，其中每个answer[i]是第 i 次查询的结果。
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 *
 * 提示：
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-strings-by-frequency-of-the-smallest-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution1170 {
    public static void main(String[] args) {
        String[] queries = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};

        String[] words = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};

        int[] ints = numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsCount = new int[words.length];
        int[] queriesCount = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            wordsCount[i] = findMinWordsCount(words[i]);
        }
        Arrays.sort(wordsCount);
        for (int i = 0; i < queries.length; i++) {
            queriesCount[i] = findMinWordsCount(queries[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            int j = wordsCount.length-1;
            while (j >= 0 && queriesCount[i] < wordsCount[j]) {
                j--;
            }
            queriesCount[i] = wordsCount.length - j - 1;
        }


        return queriesCount;
    }

    public static int findMinWordsCount(String s) {
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count ++;
            } else if (c > s.charAt(i)) {
                c = s.charAt(i);
                count = 1;
            }
        }
        return count;
    }

//    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
//        int[] wordsArray = new int[2000];
//        int[] result = new int[queries.length];
//        for (String word : words) {
//            char[] chars = word.toCharArray();
//            Arrays.sort(chars);
//            String s = new String(chars);
//            int i = 0;
//            int temp = 0;
//            int i1 = s.lastIndexOf(s.charAt(i));
//            temp = i1 + 1;
//            wordsArray[temp] = wordsArray[temp] + 1;
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            int maxWords = 0;
//            char[] chars = queries[i].toCharArray();
//            Arrays.sort(chars);
//            String s = new String(chars);
//
//            int temp = 0;
//            int i1 = s.lastIndexOf(s.charAt(0));
//            temp = i1  + 1;
//            result[i] = temp;
//        }
//
//        /*for (int i = 0; i < wordsArray.length; i++) {
//            if(wordsArray[i] != 0) {
//                System.out.println(i + " = " + wordsArray[i]);
//            }
//        }*/
//
//        for (int i = 0; i < queries.length; i++) {
//            int sum = 0;
//            for (int j = result[i] + 1; j < wordsArray.length; j++) {
//                if(wordsArray[j] != 0) {
//                    sum += wordsArray[j];
//                }
//            }
//            result[i] = sum;
//        }
//
////        System.out.println();
//
//
//        return result;
//    }
}
