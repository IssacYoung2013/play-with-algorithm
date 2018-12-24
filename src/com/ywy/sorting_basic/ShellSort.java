package com.ywy.sorting_basic;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class ShellSort {

    private ShellSort() {
    }

    /**
     * 相比选择排序 提前终止
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                Comparable sentinal = arr[i];
                int j = i;
                for (; j >= h && arr[j-h].compareTo(sentinal) > 0 ; j-=h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = sentinal;
            }

            h /= 3;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
