package com.ywy.heap;

import com.ywy.sorting_advance.SortTestHelper;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-24
 * desc: 不使用一个额外
 */
public class HeapSort2 {

    private HeapSort2() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        // 最大的推到堆顶
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, n, i);
        }

        for (int i = n - 1; i > 0 ; i--) {
            swap(arr,0,i);
            shiftDown2(arr,i,0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {

        // 左孩子不越界
        while (2 * k + 1< n) {
            int j = 2 * k + 1;

            // 右孩子不越界
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private static void shiftDown2(Comparable[] arr,int n,int k) {
        Comparable e = arr[k];

        while (2 * k + 1<n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j++;
            }
            if (e.compareTo(arr[j]) >= 0) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }

        arr[k] = e;

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N,100);
        Integer[] arr1 = Arrays.copyOfRange(arr, 0, N);
        Integer[] arr2 = Arrays.copyOfRange(arr, 0, N);

        SortTestHelper.testSort("com.ywy.heap.HeapSort", arr);
        SortTestHelper.testSort("com.ywy.heap.HeapSort1", arr1);
        SortTestHelper.testSort("com.ywy.heap.HeapSort2", arr2);

    }
}
