class Solution {
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m][n];


        return dfs(0, 0, m, n, visited);
    }

    private int dfs(int si, int sj, int ei, int ej, int[][] visited) {
        if (si >= ei || sj >= ej) {
            return 0;
        }
        if (si == ei - 1 && sj == ej - 1) {
            return visited[si][sj] + 1;
        }

        if (visited[si][sj] != 0)
            return visited[si][sj];

        visited[si][sj] = dfs(si + 1, sj, ei, ej, visited) + dfs(si, sj + 1, ei, ej, visited);


        return visited[si][sj];
    }
}