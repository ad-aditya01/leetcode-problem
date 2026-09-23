class Solution {
    public int minOperations(int[] nums, int x) {
        long total = 0;
        for (int v : nums) total += v;

        long target = total - x;
        if (target < 0) return -1;
        if (target == 0) return nums.length;

        int left = 0, best = -1;
        long cur = 0;
        for (int right = 0; right < nums.length; right++) {
            cur += nums[right];
            while (cur > target) {
                cur -= nums[left++];
            }
            if (cur == target) {
                best = Math.max(best, right - left + 1);
            }
        }
        return best == -1 ? -1 : nums.length - best;
    }
}