class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) 
                {
                    dfs(grid, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 0) 
                {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, int i, int j)
     {
        if (i < 0 || j < 0 || i >= grid.length ||
            j >= grid[0].length || grid[i][j] == 1)
        {
            return;
        }

        grid[i][j] = 1;

        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
}
