import java.util.*;

class Solution {

    int[][] maxST;
    int[][] minST;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            long v = getValue(l, n - 1);
            pq.offer(new Node(v, l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                long nv = getValue(cur.l, nr);
                pq.offer(new Node(nv, cur.l, nr));
            }
        }

        return ans;
    }

    private long getValue(int l, int r) {
        return (long) queryMax(l, r) - queryMin(l, r);
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        maxST = new int[K][n];
        minST = new int[K][n];

        for (int i = 0; i < n; i++) {
            maxST[0][i] = nums[i];
            minST[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxST[j][i] =
                        Math.max(maxST[j - 1][i],
                                 maxST[j - 1][i + (1 << (j - 1))]);

                minST[j][i] =
                        Math.min(minST[j - 1][i],
                                 minST[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    private int queryMax(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        return Math.max(
                maxST[j][l],
                maxST[j][r - (1 << j) + 1]
        );
    }

    private int queryMin(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        return Math.min(
                minST[j][l],
                minST[j][r - (1 << j) + 1]
        );
    }

    static class Node {
        long val;
        int l;
        int r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }
}