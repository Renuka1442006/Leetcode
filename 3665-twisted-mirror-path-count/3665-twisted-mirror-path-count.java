class Solution {
    static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 1) {

                    // Entered mirror while moving RIGHT
                    // Reflection sends robot DOWN
                    if (i + 1 < m) 
                    {
                        down[i + 1][j] = (int)(
                            ((long) down[i + 1][j] + right[i][j]) % MOD
                        );
                    }

                    // Entered mirror while moving DOWN
                    // Reflection sends robot RIGHT
                    if (j + 1 < n) 
                    {
                        right[i][j + 1] = (int)(
                            ((long) right[i][j + 1] + down[i][j]) % MOD
                        );
                    }

                } 
                else {
                    // Normal empty cell
                    long ways = ((long) right[i][j] + down[i][j]) % MOD;

                    // Starting position
                    if (i == 0 && j == 0) 
                    {
                        ways = 1;
                    }

                    // Move RIGHT
                    if (j + 1 < n) 
                    {
                        right[i][j + 1] = (int)(
                            (right[i][j + 1] + ways) % MOD
                        );
                    }

                    // Move DOWN
                    if (i + 1 < m) 
                    {
                        down[i + 1][j] = (int)(
                            (down[i + 1][j] + ways) % MOD
                        );
                    }
                }
            }
        }

        return (int)(
            ((long) right[m - 1][n - 1] +
             down[m - 1][n - 1]) % MOD
        );
    }
}