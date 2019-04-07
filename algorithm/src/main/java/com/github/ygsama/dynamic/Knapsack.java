package com.github.ygsama.dynamic;

import java.util.Arrays;

/**
 * 0-1背包问题 <br/>
 * n个物品，第i个物品，价值为Vi，重量为Wi，背包的容量为W，求最优解
 *
 * @author ygsama
 * @since 2019-04-07
 */
public class Knapsack {

    public static void main(String[] args) {

        int[] weight = {3, 4, 7, 8, 9};
        int[] value = {4, 5, 10, 11, 13};
        int w = 17;
        int[][] ints = Knapsack.knapsackDP(w, weight, value);
        int[] x = Knapsack.outPutKnapsackDP(w, weight, value, ints);

        for (int[] i : ints) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(Arrays.toString(x));
    }


    /**
     * <h1/>动态规划
     * <h2/>1、最优解的性质和结构
     * <p/>最优解的结构：(X1, X2, X3, ... Xn) ，如(0, 1, 0, 1, 1)        <br/>
     * 最优解的性质：物品价值=SUM(Vi*Xi)，最大物品价值：MAX( SUM(Vi*Xi))     <br/>
     * 最优解的约束条件：SUM(Wi*Xi) <= W                                 <br/>
     * <p>
     * <h2/>2、最优解的递归定义
     * <p/>设：背包容量为w时，i个物品最优解的总价值    F=(i,w)              <br/>
     * i=0 or w=0    , F(i,w) = 0                       不放物品  <br/>
     * i>0 and Wi>W  , F(i,w) = F(i-1,w)                物品超过背包重量 <br/>
     * i>0 and Wi<=W , MAX{ F(i-1,w-Wi)+Vi, F(i-1,w) }  可以继续放物品   <br/>
     * F(i-1,w-Wi)+Vi : 放这个物品的最大价值                                 <br/>
     * F(i-1,w) : 不放这个物品的最大价值                                      <br/>
     * <p>
     * <h2/>3、从下往上计算每个解
     */
    static int[][] knapsackDP(int maxWeight, int[] weight, int[] value) {

        if (weight.length != value.length || maxWeight <= 0) {
            return null;
        }
        int[][] note = new int[weight.length + 1][maxWeight + 1];

        for (int i = 1; i <= weight.length; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weight[i - 1] <= w) {
                    if ((value[i - 1] + note[i - 1][w - weight[i - 1]]) > note[i - 1][w]) {
                        note[i][w] = value[i - 1] + note[i - 1][w - weight[i - 1]];
                    } else {
                        note[i][w] = note[i - 1][w];
                    }
                } else {
                    note[i][w] = note[i - 1][w];
                }
            }
        }
        return note;
    }

    /**
     * <h2/>4、根据所有解，构造最优解
     */
    static int[] outPutKnapsackDP(int maxWeight, int[] weight, int[] value, int[][] note) {
        int[] x = new int[weight.length];
        int n = weight.length;
        for (int i = n; i > 1; i--) {
            if (note[i][maxWeight] == note[i - 1][maxWeight]) {
                x[i - 1] = 0;
            } else {
                x[i - 1] = 1;
                maxWeight = maxWeight - weight[i - 1];
            }
        }
        if (note[1][maxWeight] == 0) {
            x[0] = 0;
        } else {
            x[0] = 1;
        }
        return x;
    }
}
