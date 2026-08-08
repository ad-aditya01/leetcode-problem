// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         map.put(0,1);
//         int count=0;
//         int sum=0;
//         for(int num:nums){
//             if(num%2!=0){
//                 sum=sum+1;
//             }
//             if(map.containsKey(sum-k)){
//                 count+=map.get(sum-k);
//             }
//             map.put(sum,map.getOrDefault(sum,0)+1);
//         }
//         return count;
        
//     }
// }

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0;
        int oddCount = 0;
        int ans = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[i] % 2 != 0) {
                    oddCount--;
                }
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}