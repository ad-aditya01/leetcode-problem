// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int left = 0, right = 0;
//         int zeroes = 0, maxlen = 0;

//         while (right < nums.length) {
//             if (nums[right] == 0) {
//                 zeroes++;
//             }
//             while (zeroes > k) { // shrink window
//                 if (nums[left] == 0) {
//                     zeroes--;
//                 }
//                 left++;
//             }
//             maxlen = Math.max(maxlen, right-left+1);
//             right++;
//         }
//         return maxlen;
//     }
// }

class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
