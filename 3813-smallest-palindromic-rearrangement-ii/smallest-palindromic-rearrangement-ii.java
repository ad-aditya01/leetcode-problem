import java.util.*;

class Solution {

    static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        String mid = "";

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1)
                mid = "" + (char) ('a' + i);
            freq[i] /= 2;
        }

        int len = 0;
        for (int x : freq)
            len += x;

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {

            boolean found = false;

            for (int c = 0; c < 26; c++) {

                if (freq[c] == 0)
                    continue;

                freq[c]--;

                long cnt = countWays(freq);

                if (cnt >= k) {
                    left.append((char) ('a' + c));
                    found = true;
                    break;
                } else {
                    k -= cnt;
                    freq[c]++;
                }
            }

            if (!found)
                return "";
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + mid + right;
    }

    private long countWays(int[] freq) {

        int total = 0;
        for (int x : freq)
            total += x;

        long ans = 1;

        int remain = total;

        for (int f : freq) {

            if (f == 0)
                continue;

            ans *= nCr(remain, f);

            if (ans > LIMIT)
                return LIMIT;

            remain -= f;
        }

        return ans;
    }

    private long nCr(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - r + i) / i;

            if (ans > LIMIT)
                return LIMIT;
        }

        return ans;
    }
}