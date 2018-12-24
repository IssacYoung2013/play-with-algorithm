package com.ywy.sorting_advance;

import java.util.Arrays;

/**
 * author:  ywy
 * date:    2018-12-22
 * desc:
 */
public class InversionCount {
    private InversionCount() {
    }

    public static long solve(Comparable[] arr) {
        int n = arr.length;
        return solve(arr, 0, n - 1);
    }

    /**
     * 递归使用归并排序，对arr[l...r) 的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static long solve(Comparable[] arr, int l, int r) {

        if (l >= r) {
            return 0L;
        }

        // 隐含风险 （l+r）溢出
        int mid = (l + r) / 2;
        long res1 = solve(arr, l, mid);
        long res2 = solve(arr, mid + 1, r);

        return res1 + res2 + merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid] 和 arr[mid + 1...r] 两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static long merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        long res = 0L;

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
                res += (long) (mid-i+1);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {

        int N = 4;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.printArray(arr);
        System.out.println("Test Inversion Count for Random Array,n = " + N + " :" + solve(arr));
    }
}
