package com.ywy.sorting_advance;

import com.ywy.sorting_advance.SortTestHelper;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class Main {
    public static void main(String[] args) {
        // n 设置太大 insertsort 会耗时非常长
//        int n = 100000;
//        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(n, 100);
//        Integer[] arr1 = SortTestHelper.generateRandomArray(n,0,10);
//        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
//        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

//        SortTestHelper.testSort("com.ywy.sorting_advance.InsertSort", arr1);
//        SortTestHelper.testSort("com.ywy.sorting_advance.MergeSort", arr2);
//        SortTestHelper.testSort("com.ywy.sorting_advance.MergeSort2", arr3);
//        SortTestHelper.testSort("com.ywy.sorting_advance.MergeSortBU", arr4);
//        SortTestHelper.testSort("com.ywy.sorting_advance.QuickSort", arr5);
//        SortTestHelper.testSort("com.ywy.sorting_advance.QuickSort2", arr3);
//        SortTestHelper.testSort("com.ywy.sorting_advance.QuickSort3", arr4);


        // 对比 Shell Sort Merge Sort Quick Sort 性能效率

        int T = 100;
        int N = 100000;

        long time1 = 0, time2 = 0, time3 = 0, time4 = 0, time5 = 0;
        for (int i = 0; i < T; i++) {
            Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

            time1 += SortTestHelper.testSort2("com.ywy.sorting_basic.ShellSort", arr1);
            time2 += SortTestHelper.testSort2("com.ywy.sorting_advance.MergeSort", arr2);
//        SortTestHelper.testSort("com.ywy.sorting_advance.MergeSort2", arr3);
//        SortTestHelper.testSort("com.ywy.sorting_advance.MergeSortBU", arr4);
            time3 += SortTestHelper.testSort2("com.ywy.sorting_advance.QuickSort", arr3);
            time4 += SortTestHelper.testSort2("com.ywy.sorting_advance.QuickSort2", arr4);
            time5 += SortTestHelper.testSort2("com.ywy.sorting_advance.QuickSort3", arr5);
        }

        System.out.println("Sorting " + N + " elements " +  T +" times. Caculate the average run time.");
        System.out.println("Shell Sort          Average Run Time:" + time1/T +" ms");
        System.out.println("Merge Sort          Average Run Time:" + time2/T +" ms");
        System.out.println("Quick Sort          Average Run Time:" + time3/T +" ms");
        System.out.println("Quick Sort 2 ways   Average Run Time:" + time4/T +" ms");
        System.out.println("Quick Sort 3 ways   Average Run Time:" + time5/T +" ms");
    }
}
