package org.wayne.spring.javase.leetcode.dp;


public class Bag01 {

    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i=1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int W = 5;
        int N = 4;
        int[] weights = {5,7,8,6};
        int[] values = {3,4,6,8};

        Bag01 bag01 = new Bag01();
        int cnt = bag01.knapsack(W, N, weights, values);
        System.out.println(cnt);

    }
}
