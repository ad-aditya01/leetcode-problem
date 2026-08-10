class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);

        int maxi=1;
        int lastIndex=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
                List<Integer> ans = new ArrayList<>();

        while (parent[lastIndex] !=-1) {

            ans.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        ans.add(nums[lastIndex]);

        Collections.reverse(ans);

        return ans;
        
    }
}