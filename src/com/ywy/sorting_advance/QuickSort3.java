package com.ywy.sorting_advance;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class QuickSort3 {

    private QuickSort3() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.sort(arr, l, r);
            return;
        }

        // partition
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];
        int lt = l; // arr[l+1..lt] < v
        int gt = r + 1; // arr[gt..r]
        int i = l + 1; // arr[lt+1...i) == v

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);

    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
