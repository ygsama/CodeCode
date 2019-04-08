package com.github.ygsama.dynamic;

import java.util.Arrays;

/**
 * 最长公共子序列问题。
 * 已知序列X=（A，B，C，A，B，D，A）和序列Y=（B，A，D，B，A）
 * 求它们的最长公共子序列S
 *
 * @author ygsama
 * @since 2019-04-07
 */
public class LCSLength {

    public static void main(String[] args) {
        String str1 = "ABCABDA";
        String str2 = "BADBA";
//        String str1 = "ABCACABDA";
//        String str2 = "BCACADBA";
        System.out.println(LCSLength.lcse(str1, str2));
    }

    /**
     * i=0 or j=0  0
     * i,j>0 and str1[i] == str2[j]  dp[i-1,j-1]+1
     * i,j>0 and str1[i] != str2[j]  max{ dp[i-1][j], dp[i][j-1]}
     * 获得矩阵dp
     * dp矩阵最右下角的值为两个序列的最长公共子序列的长度
     */
    static int[][] get_dp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = str1[i] == str2[j] ? dp[i][j] = dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }

    /**
     * B  A  D  B  A
     * A [0, 1, 1, 1, 1]
     * B [1, 1, 1, 2, 2]
     * C [1, 1, 1, 2, 2]
     * A [1, 2, 2, 2, 3]
     * B [1, 2, 2, 3, 3]
     * D [1, 2, 3, 3, 3]
     * A [1, 2, 3, 3, 4]
     * BADA
     * 通过dp矩阵求解最长公共子序列的过程
     * 就是还原出当时如何求解dp的过程，
     * 来自哪个方向的策略就朝哪个方向移动
     */
    static String lcse(String s1, String s2) {
        if (s1 == null || s2 == null || "".equals(s1) || "".equals(s2)) {
            return "";
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = get_dp(c1, c2);
        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        int m = c1.length - 1;
        int n = c2.length - 1;
        char[] result = new char[dp[m][n]];
        int index = result.length - 1;
        while (index >= 0) {

            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                // 向左移动
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                // 向上移动
                m--;
            } else {
                // 向左上方移动
                result[index--] = c1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(result);
    }


}
