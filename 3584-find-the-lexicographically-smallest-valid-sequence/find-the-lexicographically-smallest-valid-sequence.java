class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // dp[i] = maximum number of characters
        // from the remaining suffix of word2
        // that can be matched exactly in word1[i...]
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Find the lexicographically smallest prefix.
        // We use the one mismatch at the earliest possible position.
        while (i < n && j < m) {

            // Characters match -> always take it
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            } else {

                // Use our one allowed mismatch here
                //
                // After using mismatch at i,
                // we need to match the remaining
                // m - j - 1 characters exactly.
                if (dp[i + 1] >= m - 1 - j) {

                    ans[j] = i;
                    j++;

                    i++;

                    // Mismatch is now used
                    break;
                }
            }

            i++;
        }

        // Couldn't find the complete sequence
        if (j < m && i == n) {
            return new int[0];
        }

        // Mismatch already used.
        // Now we must match the rest exactly.
        while (j < m && i < n) {

            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            i++;
        }

        // If we couldn't select all m characters
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}