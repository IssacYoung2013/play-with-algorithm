package com.ywy.sorting_advance;

import com.ywy.sorting_basic.SortTestHelper;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class InsertSort {

    private InsertSort() {
    }

    /**
     * 相比选择排序 提前终止
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            Comparable sentinel = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(sentinel) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = sentinel;
        }
    }

    public static void sort(Comparable[] arr,int l,int r) {

        int n = arr.length;
        for (int i = l + 1; i <= r; i++) {
            // 寻找元素arr[i]合适的插入位置
            Comparable sentinel = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1].compareTo(sentinel) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = sentinel;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(n,10);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1,arr1.length);

        SortTestHelper.testSort("com.ywy.sorting_basic.InsertSort",arr1);
        SortTestHelper.testSort("com.ywy.sorting_basic.SelectionSort",arr2);
        SortTestHelper.testSort("com.ywy.sorting_basic.BubbleSort",arr3);
        SortTestHelper.testSort("com.ywy.sorting_basic.BubbleSort2",arr4);
        SortTestHelper.testSort("com.ywy.sorting_basic.ShellSort",arr5);
    }
}
