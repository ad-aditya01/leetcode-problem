class Solution {
    int[][] dp;
    public int solve(int i,int j,String s){
        if(i==j) return 1;
        if(i>j ) return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+solve(i+1,j-1,s);
        }
        int left=solve(i+1,j,s);
        int right=solve(i,j-1,s);

       return dp[i][j]= Math.max(left,right);
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        dp=new int[1001][1001];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        return solve(0,n-1,s);
        
    }
}