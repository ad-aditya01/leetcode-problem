import java.util.Arrays;

class Solution {
    int[][] dp;

    public int solve(int idx, int buy, int[] prices, int fee) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        if (buy == 1) {
            dp[idx][buy] = Math.max(
                -prices[idx] + solve(idx + 1, 0, prices, fee), // Buy
                solve(idx + 1, 1, prices, fee)                 // Skip
            );
        } else {
            dp[idx][buy] = Math.max(
                prices[idx] - fee + solve(idx + 1, 1, prices, fee), // Sell
                solve(idx + 1, 0, prices, fee)                      // Skip
            );
        }

        return dp[idx][buy];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, fee);
    }
}