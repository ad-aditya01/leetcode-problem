class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n][k + 1];
        
                for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 1; j <= k; j++) {
            long prefix = 0; 
            for (int i = 0; i < n; i++) {
                long skip = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                dp[i][j] = (skip + prefix) % MOD;
                
                prefix = (prefix + dp[i][j - 1]) % MOD;
            }
        }
        
        return (int) dp[n - 1][k];
    }
}