class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2; 
        
        int[] dp = new int[n + 1];
        dp[0] = INF;
        
        int ans = INF;
        int left = 0;
        int curSum = 0;
        
        for (int right = 0; right < n; right++) {
            curSum += arr[right];
            
            while (curSum > target) {
                curSum -= arr[left];
                left++;
            }
            
            dp[right + 1] = dp[right]; 
            
            if (curSum == target) {
                int length = right - left + 1;
                if (dp[left] != INF) {
                    ans = Math.min(ans, dp[left] + length);
                }
                dp[right + 1] = Math.min(dp[right], length);
            }
        }
        
        return ans == INF ? -1 : ans;
    }
}