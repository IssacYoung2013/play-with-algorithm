package com.ywy.sorting_advance;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class MergeSort2 {
    private MergeSort2() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    /**
     * 递归使用归并排序，对arr[l...r) 的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {

        if (l -r <= 15) {
            InsertSort.sort(arr,l,r);
            return;
        }

        // 隐含风险 （l+r）溢出
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 优化1 对于arr[mid] <= arr[mid+1] 的情况下，不进行merge
        // 对于近乎有序的数组非常有效，但是对于一般情况，有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    /**
     * 将arr[l...mid] 和 arr[mid + 1...r] 两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
