// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n=nums.length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                sum+=nums[j];
//                if(sum==goal){
//                 count++;
//                }
//                 }
//             }
//             return count;
//         }
        
//     }

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         map.put(0,1);
//         int sum=0;
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//             if(map.containsKey(sum-goal)){
//                 count=count+map.get(sum-goal);

//             }
//             map.put(sum,map.getOrDefault(sum,0)+1);
//         }
//         return count;
//     }
// }

class Solution {
    public int solve(int[] nums,int goal){
        int i=0,j=0,count=0,sum=0;
        if(goal<0) return 0;
        while(j<nums.length){
            sum=sum+nums[j];

            while(sum>goal){
                sum=sum-nums[i];
                i=i+1;
            }
            count=count+(j-i+1);
            j++;
        }
        return count;

        }
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal)-solve(nums,goal-1);
    }
}
