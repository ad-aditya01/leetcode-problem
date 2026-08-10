class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        // dp[0] = false
        // No stones -> current player loses

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                // If opponent loses after our move,
                // then we can win.
                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}