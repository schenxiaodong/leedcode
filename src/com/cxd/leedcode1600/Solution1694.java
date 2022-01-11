package com.cxd.leedcode1600;

/**
 * @author Administrator
 *
 * 1694. 重新格式化电话号码
 *
 * https://leetcode-cn.com/problems/reformat-phone-number/
 */
public class Solution1694 {
    public static void main(String[] args) {
        String number = "1-23-45 6";
        System.out.println(reformatNumber(number));
    }

    /**
     * 方式三 非StringBuffer
     * @param number
     * @return
     */
    public static String reformatNumber(String number) {
        // 去除非0-9 的其他玩意
        String numberReplaceAll = number.replaceAll("[^0-9]", "");
        int len = numberReplaceAll.length();
        int realLen = 0;
        String sb = "";
        int temp = 0;
        if (len % 3 == 0) {
            realLen = len - 3;
            temp = 0;
        } else if(len % 3 == 1) {
            realLen = len - 4;
            temp = 1;
        } else if(len % 3 == 2) {
            realLen = len - 2;
            temp = 2;
        }

        for (int i = 0; i < realLen; i+=3) {
            sb += numberReplaceAll.substring(i, i+3);
            sb += ("-");
        }

        if(temp == 0) {
            sb += numberReplaceAll.substring(realLen, realLen+3);
        } else if (temp == 1){
            sb += numberReplaceAll.substring(realLen, realLen+2);
            sb += ("-");
            sb += numberReplaceAll.substring(realLen + 2, len);
        } else {
            sb += numberReplaceAll.substring(realLen, len);
        }
        return sb;
    }

    /**
     * 方式二 数学方式解决
     * @param number
     * @return
     */
//    public static String reformatNumber(String number) {
//        // 去除非0-9 的其他玩意
//        String numberReplaceAll = number.replaceAll("[^0-9]", "");
//        int len = numberReplaceAll.length();
//        int realLen = 0;
//        StringBuffer sb = new StringBuffer();
//        int temp = 0;
//        if (len % 3 == 0) {
//            realLen = len - 3;
//            temp = 0;
//        } else if(len % 3 == 1) {
//            realLen = len - 4;
//            temp = 1;
//        } else if(len % 3 == 2) {
//            realLen = len - 2;
//            temp = 2;
//        }
//
//        for (int i = 0; i < realLen; i+=3) {
//            sb.append(numberReplaceAll, i, i+3);
//            sb.append("-");
//        }
//
//        if(temp == 0) {
//            sb.append(numberReplaceAll, realLen, realLen + 3);
//        } else if (temp == 1){
//            sb.append(numberReplaceAll, realLen, realLen + 2);
//            sb.append("-");
//            sb.append(numberReplaceAll, realLen + 2, len);
//        } else {
//            sb.append(numberReplaceAll, realLen, len);
//        }
//        return sb.toString();
//
//    }

    /**
     * 方式1 傻逼办法，直接遍历
     * @param number
     * @return
     */
//    public static String reformatNumber(String number) {
//        number = number.replaceAll("[^0-9]", "");
////        number = number.replaceAll("-", "");
//        int i = 0;
//        int morelen = 0;
//        StringBuffer sb = new StringBuffer();
//        while (i < number.length()) {
//            morelen = number.length() - i;
//            if(morelen > 4 || morelen == 3) {
//                sb.append(number, i, i+3);
//                i = i + 3;
//            } else if(morelen == 4 || morelen == 2) {
//                sb.append(number, i, i+2);
//                i = i + 2;
//            }
//            sb.append("-");
//        }
//
//        sb.deleteCharAt(sb.length()-1);
//        return sb.toString();
//    }
}
