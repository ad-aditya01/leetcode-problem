class Solution {

    static class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr, i);
        }

        Result[][] dp = new Result[n + 1][5];
        Result empty = new Result(0L, new int[0]);

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = empty;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = empty;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {

                Result skip = dp[i + 1][k];

                Result remaining = dp[next[i]][k - 1];

                int[] chosen = Arrays.copyOf(
                    remaining.indices,
                    remaining.indices.length + 1
                );

                chosen[chosen.length - 1] = arr[i][3];
                Arrays.sort(chosen);

                Result take = new Result(
                    remaining.score + arr[i][2],
                    chosen
                );

                dp[i][k] = better(take, skip);
            }
        }

        return dp[0][4].indices;
    }

    private int findNext(int[][] arr, int i) {
        int low = i + 1;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid][0] > arr[i][1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private Result better(Result a, Result b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }
        int len = Math.min(a.indices.length, b.indices.length);

        for (int i = 0; i < len; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i] ? a : b;
            }
        }
        return a.indices.length <= b.indices.length ? a : b;
    }
}