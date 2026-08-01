class Solution {

    Integer[][] dp;

    public int solve(int i, int j, int[] nums) {

        if (i == j)
            return nums[i];

        if (dp[i][j] != null)
            return dp[i][j];

        int left = nums[i] - solve(i + 1, j, nums);
        int right = nums[j] - solve(i, j - 1, nums);

        return dp[i][j] = Math.max(left, right);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new Integer[n][n];

        return solve(0, n - 1, nums) >= 0;
    }
}