class Solution {
    Boolean[][] dp;
    public boolean solve(String s, String p, int i, int j) {
        if(i == 0 && j == 0) return true;
        if(j == 0) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(i == 0) {
            for(int k = 1; k <= j; k++) {
                if(p.charAt(k - 1) != '*') {
                    return dp[i][j] = false;
                }
            }
            return dp[i][j] = true;
        }
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = solve(s, p, i - 1, j - 1);
        }
        if(p.charAt(j - 1) == '*') {
            return dp[i][j] = solve(s, p, i, j - 1) || 
                             solve(s, p, i - 1, j);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, s.length(), p.length());
    }
}