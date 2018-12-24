package com.ywy.sorting_advance;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class MergeSortBU {
    private MergeSortBU() {
    }

    /**
     * 递归使用归并排序，对arr[l...r) 的范围进行排序
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;

//        for (int sz = 1; sz <= n; sz += sz) {
//            for (int i = 0; i + sz < n; i += sz + sz) {
//                // 对 arr[i...i+sz-1] 和 arr[i+sz... + i+ 2*sz-1]进行归并
//                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
//            }
//        }

        // 小数组采用插入排序
        for (int i = 0; i < n; i += 16) {
            InsertSort.sort(arr, i, Math.min(i + 15, n - 1));
        }

        for (int sz = 16; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
                }
            }
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
