package oop;

import java.util.*;


public class ArrayT {
    /**
     * 入口函数
     * @param args 参数
     */
    public static void main(String[] args) {
        //new int[]简写
        int []a1 = {1,2,3};
        System.out.println("a1 length: " + a1.length);
        //for each循环能够遍历所有“可迭代”的数据类型，例如List、Map等
        for (int item : a1) {
            System.out.println("a1 的值：" + item);
        }

        //二维数组，每一维可以不一样
        int[][] a = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 3, 5, 6}};
        System.out.println(Arrays.deepToString(a));

        /*
         * Arrays工具类的中的几个常用方法
         * 1.copyof
         * 2.toString
         * 3.equals
         * 4.sort
         * 5.fill
         * 6.binarySearch
         */
        Arrays.sort(a[2]);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }

        String[] strArr  = {"北京", "上海", "重庆", "深圳"};
        String[] strArr1 = Arrays.copyOf(strArr, 3);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(strArr1));
    }
}