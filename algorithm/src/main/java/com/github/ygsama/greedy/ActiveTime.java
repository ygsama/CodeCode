package com.github.ygsama.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 活动选择问题
 * 1、建立数学模型来描述问题；
 * 2、把求解的问题分成若干个子问题；
 * 3、对每一子问题求解，得到子问题的局部最优解；
 * 4、把子问题的解局部最优解合成原来解问题的一个解。
 * https://blog.csdn.net/ii1245712564/article/details/45420061
 * https://blog.csdn.net/cyp331203/article/details/43199963
 *
 * @author ygsama
 * @since 2019-04-10
 */
public class ActiveTime {

    public static void main(String[] args) {
        int[] s = {0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};

        quickSort(f, s, 0, f.length - 1);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(f));

        List<Integer> list = recursiveActivitySelector(s, f, 0, new ArrayList<>());
        List<Integer> list1 = greedyActivitySelector(s, f, new ArrayList<>());
        System.out.println(list);
        System.out.println(list1);
    }

    private static List<Integer> recursiveActivitySelector(int[] s, int[] f, int index, List<Integer> option) {
        int m = index + 1;
        int n = s.length - 1;
        while (m <= n && s[m] <= f[index]) {
            m++;
        }
        if (m <= n) {
            option.add(m);
            recursiveActivitySelector(s, f, m, option);
        }
        return option;
    }

    private static List<Integer> greedyActivitySelector(int[] s, int[] f, List<Integer> option) {
        int k = 1;
        option.add(k);

        for (int m = 2; m <= s.length - 1; m++) {
            if (s[m] >= f[k]) {
                option.add(m);
                k = m;
            }
        }

        return option;
    }


    private static void quickSort(int[] a, int[] b, int low, int high) {
        int pivot;
        if (low < high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot = partition0(a, b, low, high);

            //对两边的数组分别排序
            quickSort(a, b, low, pivot - 1);
            quickSort(a, b, pivot + 1, high);
        }
    }

    /**
     * 选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
     */
    private static int partition0(int[] L, int[] b, int low, int high) {
        int pivot = L[low];
        while (low < high) {
            //从后往前找到比key小的放到前面去
            while (low < high && L[high] >= pivot) {
                high--;
            }
            swap(L, b, low, high);
            //从前往后找到比key大的 放到后面去
            while (low < high && L[low] <= pivot) {
                low++;
            }
            swap(L, b, low, high);
        }
        return low;
    }

    private static void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        temp = b[i];
        b[i] = b[j];
        b[j] = temp;
    }


}
