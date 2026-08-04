class Solution {
    int[][] dp;
    public int solve(int i,int j,ArrayList<Integer> list){
        if(i>j) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=list.get(j+1)-list.get(i-1)
                     + solve(i,k-1,list)
                     + solve(k+1,j,list);

         min=Math.min(min,cost);            
        }
        return dp[i][j]= min;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> list=new ArrayList<>();
        int m=cuts.length;
        dp=new int[m+2][m+2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(cuts);
        list.add(0);
        for(int num:cuts){
            list.add(num);
        }
        list.add(n);
        return solve(1,cuts.length,list);
        
    }
}