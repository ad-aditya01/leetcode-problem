class Solution {
    public int distinctSubseqII(String s) {

        int n = s.length();
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];

        // last occurrence of each character
        int[] last = new int[26];

        // dp[0] represents empty subsequence
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            char ch = s.charAt(i - 1);

            // double all previous subsequences
            dp[i] = (2 * dp[i - 1]) % MOD;

            int index = ch - 'a';

            // if character appeared before
            if (last[index] != 0) {

                int previousPosition = last[index];

                dp[i] = (dp[i] - dp[previousPosition - 1] + MOD) % MOD;
            }

            // update last occurrence
            last[index] = i;
        }

        // remove empty subsequence
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}