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
        System.out.println(eratosthenes(100));
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

    /**
     * 解题方法2-埃塞法
     * 用空间换取时间，如果值过大（空间开辟太大），就会报错
     */
    public static int eratosthenes(int n) {
        // 1. 建立一个空间大小为 n+1 的boolean类型的数组，初始值都为false，即定义所有的数都为素数
        boolean[] isPrime = new boolean[n+1];
        // 2. 定义标志位count
        int count = 0;
        // 从2-n遍历
        for (int i = 2; i <= n; i++) {
            // 如果i为素数
            if(!isPrime[i]) {
                // 从 i * i 开始遍历，以temp * i的数都标记为非素数
                // 例如， 2*2，2*3，2*4........
                //       3*3，3*4，3*5........
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
                // 当前 count + 1
                count++;
            }
        }
        // 返回素数总数
        return count;
    }
}
