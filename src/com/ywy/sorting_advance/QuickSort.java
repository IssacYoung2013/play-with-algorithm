package com.ywy.sorting_advance;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 对 arr[l..r] 部分进行partition操作
     * 返回 p 使得arr[l...p-1] < arr[p] ; arr[p+1...r] >arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i] > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
