class Solution {
    public String lexGreaterPermutation(String s, String target) {
         int n = s.length();

        int[] freq = new int[26];

        // Count characters of s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        int i = 0;

        // Try to make prefix equal to target
        while (i < n) {

            int t = target.charAt(i) - 'a';

            // Same character is available
            if (freq[t] > 0) {

                ans[i] = target.charAt(i);
                freq[t]--;
                i++;

            } else {

                // Same character is not available.
                // Try a larger character.
                for (int c = t + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[i] = (char) ('a' + c);
                        freq[c]--;

                        return buildAnswer(ans, i + 1, freq);
                    }
                }

                // No larger character.
                // We have to backtrack.
                break;
            }
        }

        /*
         * Either:
         * 1. We matched the entire target, or
         * 2. We got stuck at position i.
         *
         * Backtrack through the matched prefix.
         */

        int pos = i - 1;

        while (pos >= 0) {

            // Restore the character used at this position
            int current = ans[pos] - 'a';
            freq[current]++;

            int targetChar = target.charAt(pos) - 'a';

            // Find the smallest available character
            // greater than target[pos]
            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    ans[pos] = (char) ('a' + c);
                    freq[c]--;

                    return buildAnswer(ans, pos + 1, freq);
                }
            }

            pos--;
        }

        return "";
    }


    private String buildAnswer(char[] ans, int index, int[] freq) {

        int pos = index;

        // Put remaining characters in sorted order
        for (int c = 0; c < 26; c++) {

            while (freq[c] > 0) {

                ans[pos] = (char) ('a' + c);
                pos++;

                freq[c]--;
            }
        }

        return new String(ans);
    }
}