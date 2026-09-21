class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int v = num % k;
            long[] next = new long[k];

            // extend all subarrays ending at previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    next[(r * v) % k] += dp[r];
                }
            }
            // start a new subarray with just this element
            next[v % k]++;

            dp = next;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }
        return result;
    }
}