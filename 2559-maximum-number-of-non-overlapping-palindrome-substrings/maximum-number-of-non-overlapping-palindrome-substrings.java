class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        
        char[] c = s.toCharArray();
                boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalin[i][i] = true;
        for (int i = 0; i < n - 1; i++) isPalin[i][i+1] = (c[i] == c[i+1]);
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                isPalin[i][j] = (c[i] == c[j]) && isPalin[i+1][j-1];
            }
        }
        
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            
            if (i >= k) {
                int start = i - k;
                if (isPalin[start][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[start] + 1);
                }
            }
            
            if (i >= k + 1) {
                int start = i - k - 1;
                if (isPalin[start][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[start] + 1);
                }
            }
        }
        
        return dp[n];
    }
}