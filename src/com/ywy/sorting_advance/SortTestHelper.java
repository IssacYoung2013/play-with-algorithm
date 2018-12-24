package com.ywy.sorting_advance;

import java.lang.reflect.Method;

/**
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }

        return arr;
    }

    /**
     * 生成一个有序数组，随机交换swapTimes对数据的影响
     * @param n
     * @param swapTimes
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n,int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t  = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    public static void printArray(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }

        System.out.println();

        return;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr) {

        try {
            // 通过 className 获取 class 对象
            Class sortClass = Class.forName(sortClassName);

            // 获取 Class 对象的排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            // 排序函数只有一个参数
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            
            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static long testSort2(String sortClassName, Comparable[] arr) {

        try {
            // 通过 className 获取 class 对象
            Class sortClass = Class.forName(sortClassName);

            // 获取 Class 对象的排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            // 排序函数只有一个参数
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            return endTime - startTime;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }



    public static void main(String[] args) {
        Integer[] randomInts = generateRandomArray(100, 8, 109);
        printArray(randomInts);
    }

}
