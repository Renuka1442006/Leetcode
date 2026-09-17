class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // int m=mat.length;
        // int n=mat[0].length;
        // int[][] ans=new int[m][n];
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         int sum=0;
        //         for(int r=i-k;r<=i+k;r++)
        //         {
        //             for(int c=j-k;c<=j+k;c++)
        //             {
        //                 if(r>=0 && r<m && c>=0 && c<n)
        //                 {
        //                     sum+=mat[r][c];
        //                 }
        //             }
        //         }
        //         ans[i][j]=sum;
        //     }
        // }
        // return ans;
        int m=mat.length;
        int n=mat[0].length;
        int ans[][]=new int[m][n];
        int[][] prefixsum=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                prefixsum[i][j]=mat[i-1][j-1]+prefixsum[i-1][j]+prefixsum[i][j-1]-prefixsum[i-1][j-1];
            }

        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int r1=Math.max(0,i-k);
                int c1=Math.max(0,j-k);
                int r2=Math.min(m-1,i+k);
                int c2=Math.min(n-1,j+k);
                r1++;
                r2++;
                c1++;
                c2++;
                ans[i][j]=prefixsum[r2][c2]
                          -prefixsum[r1-1][c2]
                          -prefixsum[r2][c1-1]
                          +prefixsum[r1-1][c1-1];
            }
        }
        return ans;
    }
}