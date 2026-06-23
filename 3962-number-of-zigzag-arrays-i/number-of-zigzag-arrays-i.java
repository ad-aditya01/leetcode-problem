class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        for (int len = 3; len <= n; len++) {

            long[] prefixDown = new long[m + 1];
            long[] prefixUp = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefixDown[v] = (prefixDown[v - 1] + down[v]) % MOD;
                prefixUp[v] = (prefixUp[v - 1] + up[v]) % MOD;
            }

            long totalUp = prefixUp[m];

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                // sum of down[u] where u < v
                newUp[v] = prefixDown[v - 1];

                // sum of up[u] where u > v
                newDown[v] =
                        (totalUp - prefixUp[v] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}