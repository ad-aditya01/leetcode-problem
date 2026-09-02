class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int max=0;
        int count=0;
        Arrays.sort(nums);

        int j=1;

        if(nums.length==0){
            return 0;
        }
        while(j<n){
            if(nums[j]==nums[j-1]+1){
                count++;
            }else if(nums[j]>nums[j-1]+1){
                count=0;
            }
            j++;
            max=Math.max(count,max);
        }
        return max+1;
        
    }
}