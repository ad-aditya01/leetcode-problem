class Solution {
    int[] dp;
    public boolean isPalindrome(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
    public int solve(int i,int n,String s){
        if(i==n) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i,j,s)){
                int ans=1+solve(j+1,n,s);
                min=Math.min(min,ans);
            }
        }
        return dp[i]=min;
    }
    public int minCut(String s) {
        
        int n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,s)-1;
    }
}