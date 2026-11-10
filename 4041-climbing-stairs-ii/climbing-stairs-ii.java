class Solution {
    int solve(int idx,int[] costs,int[] dp){
        if(idx==0) return 0;
        if(dp[idx]!=0){
            return dp[idx];
        }
        int minCost=Integer.MAX_VALUE;
        for(int jump=1; jump<=3 && idx-jump>=0; jump++){
            int currCost=solve(idx-jump,costs,dp)+ jump*jump;
            minCost=Math.min(minCost,currCost+costs[idx-1]);
        }
        return dp[idx]=minCost;
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        return solve(n,costs,dp);
        
    }
}