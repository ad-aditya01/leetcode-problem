class Solution {
     int[][][] dp;
    public int solve(int idx,int buy,int k,int[] prices){
        int n=prices.length;
        if(idx==n || k==0) return 0;

        if(dp[idx][buy][k]!=-1){
            return dp[idx][buy][k];
        }
        if(buy==1){
            return dp[idx][buy][k]= Math.max(-prices[idx]+solve(idx+1,0,k,prices),0+solve(idx+1,1,k,prices));
        }else{
            return dp[idx][buy][k]= Math.max(prices[idx]+solve(idx+1,1,k-1,prices),solve(idx+1,0,k,prices));
        }
    }
    public int maxProfit(int k, int[] prices) {
        dp=new int[1001][2][101];
        for(int[][] mat:dp){
            for(int[] row:mat){
                Arrays.fill(row,-1);
            }
        }
        
        return solve(0,1,k,prices);
    }
}