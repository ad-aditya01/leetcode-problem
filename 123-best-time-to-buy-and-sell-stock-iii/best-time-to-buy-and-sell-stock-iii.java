class Solution {
    int[][][] dp;
    public int solve(int idx,int buy,int trans,int[] prices){
        int n=prices.length;
        if(idx==n || trans==0) return 0;

        if(dp[idx][buy][trans]!=-1){
            return dp[idx][buy][trans];
        }
        if(buy==1){
            return dp[idx][buy][trans]= Math.max(-prices[idx]+solve(idx+1,0,trans,prices),0+solve(idx+1,1,trans,prices));
        }else{
            return dp[idx][buy][trans]= Math.max(prices[idx]+solve(idx+1,1,trans-1,prices),solve(idx+1,0,trans,prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][2][3];
        for(int[][] mat:dp){
            for(int[] row:mat){
            Arrays.fill(row,-1);
            }
        }
        return solve(0,1,2,prices);
        
    }
}