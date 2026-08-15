// import java.util.*;
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
       
//     if (nums == null || nums.length < 3) return new ArrayList<>();

//     Arrays.sort(nums);
//     Set<List<Integer>> result = new HashSet<>();

//     for (int i = 0; i < nums.length - 2; i++)
//     {
//       int left = i + 1;
//       int right = nums.length - 1;

//       while (left < right) {
//         int sum = nums[i] + nums[left] + nums[right];

//         if (sum == 0) {

//           result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//           left++;
//           right--;
//         } else if (sum < 0)
//           left++;
//         else
//           right--;
//       }
//     }
//     return new ArrayList<>(result);
//     }
// }

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {

                    res.add(Arrays.asList(
                        nums[i],
                        nums[l],
                        nums[r]
                    ));

                    // Skip duplicate left values
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    // Skip duplicate right values
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;

                } else if (sum < 0) {

                    l++;

                } else {

                    r--;
                }
            }
        }

        return res;
    }
}