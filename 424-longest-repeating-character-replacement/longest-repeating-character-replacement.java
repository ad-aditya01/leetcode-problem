// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] freq=new int[26];
//        int left=0;
//        int maxFreq=0;
//        int maxLength=0;
//        for(int right=0;right<s.length();right++){
//         char ch=s.charAt(right);
//         freq[ch-'A']++;
//         maxFreq=Math.max(maxFreq,freq[ch-'A']);

//         while((right-left+1)-maxFreq>k){
//             freq[s.charAt(left)-'A']--;
//             left++;
//         }
//         maxLength=Math.max(maxLength,right-left+1);
//        }
//        return maxLength;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;

            // Recompute maxFreq after adding a character
            maxFreq = 0;
            for (int i = 0; i < 26; i++) {
                maxFreq = Math.max(maxFreq, freq[i]);
            }

            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;

                // Recompute maxFreq after removing a character
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}