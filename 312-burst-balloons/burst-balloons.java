class Solution {
    int[][] dp;
    public int solve(int i,int j,ArrayList<Integer> list){
        if(i>j) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max=Integer.MIN_VALUE;
        for(int burst=i;burst<=j;burst++){
            int cost=list.get(i-1)*list.get(burst)*list.get(j+1)
                     +solve(i,burst-1,list)
                     +solve(burst+1,j,list);

            max=Math.max(max,cost);
        }
        return dp[i][j]= max;

    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
           dp=new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        ArrayList<Integer> list=new ArrayList<>();
     
        list.add(1);
        for(int num:nums){
            list.add(num);
        }
        list.add(1);
        return solve(1,n,list);
        
    }
}