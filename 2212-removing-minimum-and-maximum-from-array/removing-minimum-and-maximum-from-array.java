class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int lo = Math.min(minIdx, maxIdx);
        int hi = Math.max(minIdx, maxIdx);
        
        // Option 1: remove both from front (up to hi+1 elements)
        int fromFront = hi + 1;
        
        // Option 2: remove both from back (from lo to end)
        int fromBack = n - lo;
        
        // Option 3: remove lo from front, hi from back
        int mixed = (lo + 1) + (n - hi);
        
        return Math.min(fromFront, Math.min(fromBack, mixed));
    }
}