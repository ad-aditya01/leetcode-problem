import java.util.Arrays;

class Solution {
    int[][] dp;

    public int solve(int idx, int buy, int[] prices) {
        int n = prices.length;

        if (idx >= n)
            return 0;

        if (dp[idx][buy] != -1)
            return dp[idx][buy];

        if (buy == 1) {
            dp[idx][buy] = Math.max(
                -prices[idx] + solve(idx + 1, 0, prices),   // Buy
                solve(idx + 1, 1, prices)                   // Skip
            );
        } else {
            dp[idx][buy] = Math.max(
                prices[idx] + solve(idx + 2, 1, prices),    // Sell and cooldown
                solve(idx + 1, 0, prices)                   // Skip
            );
        }

        return dp[idx][buy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices);
    }
}