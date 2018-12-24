package com.ywy.heap;

import com.ywy.sorting_advance.SortTestHelper;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-24
 * desc:
 */
public class HeapSort1 {

    private HeapSort1() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr1 = Arrays.copyOfRange(arr,0,N);
        SortTestHelper.testSort("com.ywy.heap.HeapSort",arr);
        SortTestHelper.testSort("com.ywy.heap.HeapSort1",arr1);


    }
}
