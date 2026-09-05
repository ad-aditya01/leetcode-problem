import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Avoid checking an already-added element again
            if (answer.contains(nums[i])) {
                continue;
            }

            int count = 0;

            // Count the frequency of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                answer.add(nums[i]);
            }

            // At most two majority elements are possible
            if (answer.size() == 2) {
                break;
            }
        }

        return answer;
    }
}