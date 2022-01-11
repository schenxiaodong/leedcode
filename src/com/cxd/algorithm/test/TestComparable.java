package com.cxd.algorithm.test;

import com.cxd.algorithm.sort.Student;

/**
 * @author Administrator
 *
 * 测试Student类
 */
public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 15);
        Student s2 = new Student("李四", 55);
        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        int i = c1.compareTo(c2);
        if(i >= 0) {
            return c1;
        } else {
            return c2;
        }
    }

}
