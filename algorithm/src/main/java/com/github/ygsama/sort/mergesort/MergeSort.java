package com.github.ygsama.sort.mergesort;


/**
 * Merge Sort 归并排序 <br/>
 * 稳定的，形似二叉树，排序次数为二叉树的深度：O(N*lgN)
 *
 * @author ygsama
 * @since 2019-03-31
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1, 74, 9, 51, 2, 3, 16, 12, 6};

//        firstWay(array);

        secondWay(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + ",");
        }

    }

    /**
     * 从下往上
     * 将每两个相邻的元素进行排序
     */
    private static void firstWay(int[] array) {
        if (array == null) {
            return;
        }
        // 区间大小 n = 1, 2, 4, 6 ...
        for (int n = 1; n < array.length; n *= 2) {
            for (int start = 0; start + 2 * n <= array.length; start += 2 * n) {
                int end = start + 2 * n - 1;
                int mid = start + n - 1;
                merge(array, start, mid, end);
                if (end < array.length - 1) {
                    merge(array, start, end, array.length - 1);
                }
            }
        }
    }

    /**
     * 合并数组中的两个有序区间
     *
     * @param array 数组
     * @param start 区间一start
     * @param mid   区间一end
     * @param end   区间二end
     */
    private static void merge(int[] array, int start, int mid, int end) {

        int[] tmp = new int[end - start + 1];

        int k = 0;
        int start1 = start;
        int start2 = mid + 1;

        while (start1 <= mid && start2 <= end) {
            tmp[k++] = array[start1] <= array[start2] ? array[start1++] : array[start2++];
        }
        while (start1 <= mid) {
            tmp[k++] = array[start1++];
        }
        while (start2 <= end) {
            tmp[k++] = array[start2++];
        }

        for (int t : tmp) {
            array[start++] = t;
        }
    }

    /**
     * 从上往下
     * 每次从中间分裂，直到最后开始两两合并
     */
    private static void secondWay(int[] array, int start, int end) {
        if (array == null || start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        secondWay(array, start, mid);
        secondWay(array, mid + 1, end);
        merge(array, start, mid, end);
    }
}
