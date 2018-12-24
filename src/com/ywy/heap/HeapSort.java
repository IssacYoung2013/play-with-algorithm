package com.ywy.heap;

import com.ywy.sorting_advance.SortTestHelper;

/**
 * author:  ywy
 * date:    2018-12-24
 * desc:
 */
public class HeapSort {

    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("com.ywy.heap.HeapSort",arr);

    }
}
