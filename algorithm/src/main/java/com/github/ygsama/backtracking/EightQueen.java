package com.github.ygsama.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法-八皇后问题
 * 1、 针对所给问题，定义问题的解空间，它至少包含问题的一个（最优）解。
 * 2 、确定易于搜索的解空间结构,使得能用回溯法方便地搜索整个解空间 。
 * 3 、以深度优先的方式搜索解空间，并且在搜索过程中用剪枝函数避免无效搜索。
 *
 * @author ygsama
 */
public class EightQueen {
    private static int count = 0;

    public static void main(String[] args) {
        queen(8, 0, new ArrayList<>());
        System.out.println(count);
    }


    private static void queen(int n, int i, List<Integer> array) {
        // 到达底部，获得一个解
        if (i == n) {
            count++;
            System.out.println(array);
        } else {
            // 遍历根节点的子节点
            for (int j = 0; j < n; j++) {
                // 找到解继续迭代
                if (cheked(i, j, array)) {
                    array.add(j);
                    queen(n, i + 1, array);
                    array.remove(array.size() - 1);
                }
            }
        }
    }

    private static boolean cheked(int i, int j, List<Integer> array) {

        for (int ai = 0; ai < array.size(); ai++) {
            if (i == ai || j == array.get(ai) || i - ai == Math.abs(j - array.get(ai))) {
                return false;
            }
        }
        return true;
    }


}
