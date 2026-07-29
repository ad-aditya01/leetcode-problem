class Solution {
    int[][] dp;
    public boolean solve(int idx,int target, int[] nums){
        if(target==0) return true;
        if(idx==0) return (nums[0]==target);
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }

        boolean not_take=solve(idx-1,target,nums);
        boolean take=false;

        if(target>=nums[idx]){
            take=solve(idx-1,target-nums[idx],nums);
        }
         dp[idx][target] = (take || not_take) ? 1 : 0;
        return take || not_take;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0) return false;
        int target=totalSum/2;

        dp=new int[n+1][target+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,target,nums);
        
    }
}