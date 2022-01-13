package com.cxd.algorithm.dataStructure.primeNumber;

/**
 * @author Administrator
 *
 * 求给定值n，统计从0-n一共有多少个素数
 * 素数 从2- n 除了能被1 和本身整除的数为素数
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int i = bruteForce(100);
        System.out.println(i);
    }

    /**
     * 暴力算法
     * 暴力枚举从2 - n 的每一个数
     * @param n
     * @return
     */
    public static int bruteForce(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum += isPrime(i) ? 1: 0;
        }
        return sum;
    }

    /**
     * 暴力算法
     * 计算该值是否为素数
     * for (int i = 2; i < n; i++)
     * 从 2 - n 一个一个遍历，暴力破解存在一定浪费，可以继续优惠一下
     * for (int i = 2; i * i <= n; i++)
     *
     * 即计算了 2 * 5 就没必要计算5 * 2
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
