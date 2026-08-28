class Solution {
    public String lexPalindromicPermutation(String s, String target) {
          int n = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;

        int oddCount = 0, oddChar = -1;
        for (int c = 0; c < 26; c++) {
            if (cnt[c] % 2 == 1) { oddCount++; oddChar = c; }
        }
        if (oddCount != n % 2) return ""; // no palindrome permutation exists

        boolean hasMid = (n % 2 == 1);
        char midChar = hasMid ? (char) ('a' + oddChar) : 0;
        int half = n / 2;

        int[] pairs = new int[26];
        for (int c = 0; c < 26; c++) pairs[c] = cnt[c] / 2;

        int[] pool = pairs.clone();
        char[] X = new char[half];
        int filled = 0;
        for (; filled < half; filled++) {
            int c = target.charAt(filled) - 'a';
            if (pool[c] > 0) {
                pool[c]--;
                X[filled] = (char) ('a' + c);
            } else break;
        }

        boolean tightOk = false;
        if (filled == half) {
            tightOk = checkSuffix(X, hasMid, midChar, target, half);
        }

        if (tightOk) return build(X, hasMid, midChar);

        int limit = filled;
        int pos = (filled == half) ? half - 1 : filled;
        boolean found = false;

        while (pos >= 0) {
            if (pos < limit) {
                pool[target.charAt(pos) - 'a']++; // undo previous tight choice
            }
            int tChar = target.charAt(pos) - 'a';
            int cand = -1;
            for (int c = tChar + 1; c < 26; c++) {
                if (pool[c] > 0) { cand = c; break; }
            }
            if (cand != -1) {
                pool[cand]--;
                X[pos] = (char) ('a' + cand);
                int p = pos + 1;
                for (int c = 0; c < 26; c++) {
                    while (pool[c] > 0) {
                        X[p++] = (char) ('a' + c);
                        pool[c]--;
                    }
                }
                found = true;
                break;
            }
            pos--;
        }

        if (!found) return "";
        return build(X, hasMid, midChar);
    }

    private boolean checkSuffix(char[] X, boolean hasMid, char midChar, String target, int half) {
        String revX = new StringBuilder(new String(X)).reverse().toString();
        if (hasMid) {
            char midTarget = target.charAt(half);
            if (midChar > midTarget) return true;
            if (midChar < midTarget) return false;
            String suf = target.substring(half + 1);
            return revX.compareTo(suf) > 0;
        } else {
            String suf = target.substring(half);
            return revX.compareTo(suf) > 0;
        }
    }

    private String build(char[] X, boolean hasMid, char midChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(X);
        if (hasMid) sb.append(midChar);
        sb.append(new StringBuilder(new String(X)).reverse());
        return sb.toString();
    }
}