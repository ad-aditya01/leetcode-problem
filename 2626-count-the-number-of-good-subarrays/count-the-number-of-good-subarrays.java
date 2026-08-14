class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int i=0,j=0;
        long result=0;
        long pair=0;

        while(j<n){
           pair = pair + map.getOrDefault(nums[j], 0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(pair>=k){
                result=result+(n-j);
                map.put(nums[i],map.get(nums[i])-1);
                pair=pair-map.get(nums[i]);
                i++;
                
            }
           j++;

        }
        
     return result;
        
    }
}