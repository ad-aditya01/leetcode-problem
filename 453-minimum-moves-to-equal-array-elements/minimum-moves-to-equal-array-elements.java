class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        int res=0;
        for(int num:nums){
            min=Math.min(num,min);
        }
        for(int num:nums){
            res+=num-min;
        }
        return res;
        
    }
}