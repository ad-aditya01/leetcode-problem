class Solution {
    int[] dp;
    public int solve(int i,int[] arr,int k){
        int n=arr.length;
        if(i==n) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int max=0;
        int ans=0;
        for(int j=i;j<Math.min(n,i+k);j++){
            max=Math.max(max,arr[j]);
            int length=j-i+1;
            int cost=max*length+solve(j+1,arr,k);
            ans=Math.max(ans,cost);
        }
        return dp[i]= ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[501];
        Arrays.fill(dp,-1);
        return solve(0,arr,k);
        
    }
}