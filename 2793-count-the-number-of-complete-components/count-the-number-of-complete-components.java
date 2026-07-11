class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    int vertices;
    int edges;

    public int countCompleteComponents(int n, int[][] edgesArr) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edgesArr) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                vertices = 0;
                edges = 0;

                dfs(i);

                edges /= 2;

                if (edges == vertices * (vertices - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int node) {

        visited[node] = true;

        vertices++;

        edges += graph[node].size();

        for (int nei : graph[node]) {

            if (!visited[nei])
                dfs(nei);
        }
    }
}