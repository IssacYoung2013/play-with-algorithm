package com.ywy.sorting_basic;

/**
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // 寻找 i 到 n 的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 使用 compareTo 方法
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

//    public static void main(String[] args) {
//        Integer[] a = SortTestHelper.generateRandomArray(10,7,86);
//        SortTestHelper.printArray(a);
//        sort(a);
//        SortTestHelper.printArray(a);
//
//        String[] b = {"r","a","c","b"};
//        SortTestHelper.printArray(b);
//        sort(b);
//        SortTestHelper.printArray(b);
//
//        Student[] c = { new Student("B",88),new Student("A",99),
//                        new Student("C",100),new Student("D",88)};
//
//        SortTestHelper.printArray(c);
//        sort(c);
//        SortTestHelper.printArray(c);
//    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.ywy.sorting_basic.SelectionSort", arr);
    }

}
