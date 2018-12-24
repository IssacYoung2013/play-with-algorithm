package com.ywy.sorting_basic;

/**
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if(arr[i].compareTo(arr[j]) > 0) {
//                    swap(arr,i,j);
//                }
//            }
//        }

        boolean swapped = false;
        do {

            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }
            n--;

        } while (swapped);

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
