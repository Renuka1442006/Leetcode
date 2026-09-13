class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp=new int[n][n];
        int ans[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ncol=(j-rowShift[i]+n)%n;
                temp[i][ncol]=grid[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ncol=(i-colShift[j]+n)%n;
                ans[ncol][j]=temp[i][j];
            }
        }
        return ans;
    }
}