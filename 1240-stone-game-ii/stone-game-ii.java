class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = sum of piles from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles remaining
        if (i >= n) {
            return 0;
        }

        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return dp[i][M] = suffix[i];
        }

        int best = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            // Stones current player gets
            int current = suffix[i]
                        - solve(i + X, newM);

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}