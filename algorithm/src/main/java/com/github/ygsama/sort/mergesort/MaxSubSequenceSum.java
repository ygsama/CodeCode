package com.github.ygsama.sort.mergesort;

/**
 * 求最大子段和
 * 穷举法、分治法、动态规划
 *
 * @author ygsama
 * @since 2019-04-01
 */
public class MaxSubSequenceSum {

    public static void main(String[] args) {
//        int[] array = {1, 74, -9, -60, 51, 2, 3, -90, 16, 12, 6};
//        int[] array = {-1, 74, -9, -60, -51, -2, 3, -90, -16, -12, 6};
        int[] array = {-1, -1, 4, -1, -1, -1, 4};

        int sum = maxSub(array, 0, array.length - 1);

        System.out.println(sum);

    }

    /**
     * 分治法
     *
     * @param array 整数数组
     * @param start 开始索引
     * @param end   结束索引
     * @return 求最大子段和
     */
    private static int maxSub(int[] array, int start, int end) {

        if (start == end) {
            return array[start];
        }

        int mid = (start + end) / 2;
        // 左区间Sum、右区间Sum
        int leftSum = maxSub(array, start, mid);
        int rightSum = maxSub(array, mid + 1, array.length - 1);

        // 中间区间Sum
        int tmp = 0;
        int leftTmp = 0;
        int rightTmp = 0;
        for (int i = mid; i >= start; i--) {
            tmp += array[i];
            leftTmp = tmp > leftTmp ? tmp : leftTmp;
        }
        tmp = 0;
        for (int i = mid + 1; i <= end; i++) {
            tmp += array[i];
            rightTmp = tmp > rightTmp ? tmp : rightTmp;
        }
        tmp = rightTmp + leftTmp;

        // 取最大值
        tmp = tmp > leftSum ? tmp : leftSum;
        tmp = tmp > rightSum ? tmp : rightSum;
        return tmp;
    }

}
