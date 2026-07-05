class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int MOD = 1_000_000_007;
        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == 0 && j == 0)
                    continue;

                int best = -1;
                long cnt = 0;

                // from top
                if (i > 0 && score[i - 1][j] != -1) {
                    best = score[i - 1][j];
                    cnt = ways[i - 1][j];
                }

                // from left
                if (j > 0 && score[i][j - 1] != -1) {

                    if (score[i][j - 1] > best) {
                        best = score[i][j - 1];
                        cnt = ways[i][j - 1];
                    } else if (score[i][j - 1] == best) {
                        cnt += ways[i][j - 1];
                    }
                }

                // from diagonal
                if (i > 0 && j > 0 && score[i - 1][j - 1] != -1) {

                    if (score[i - 1][j - 1] > best) {
                        best = score[i - 1][j - 1];
                        cnt = ways[i - 1][j - 1];
                    } else if (score[i - 1][j - 1] == best) {
                        cnt += ways[i - 1][j - 1];
                    }
                }

                if (best == -1)
                    continue;

                char ch = board.get(i).charAt(j);

                int val = 0;
                if (ch >= '1' && ch <= '9')
                    val = ch - '0';

                score[i][j] = best + val;
                ways[i][j] = (int) (cnt % MOD);
            }
        }

        if (ways[n - 1][n - 1] == 0)
            return new int[] {0, 0};

        return new int[] {score[n - 1][n - 1], ways[n - 1][n - 1]};
    }
}