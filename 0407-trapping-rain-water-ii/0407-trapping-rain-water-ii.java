class Solution {
    public int trapRainWater(int[][] heightMap) 
    {
        // int m = heightMap.length;
        // int n = heightMap[0].length;
        // int totalwater = 0;
        // int[][] a = new int[m][n]; 
        // int[][] b = new int[m][n]; 
        // int[][] c = new int[m][n]; 
        // int[][] d = new int[m][n]; 
        // for (int i = 0; i < m; i++) 
        // {
        //     a[i][0] = heightMap[i][0];
        //     for (int j = 1; j < n; j++) 
        //     {
        //         a[i][j] = Math.max(a[i][j - 1], heightMap[i][j]);
        //     }
        // }
        // for (int i = 0; i < m; i++) 
        // {
        //     b[i][n - 1] = heightMap[i][n - 1];
        //     for (int j = n - 2; j >= 0; j--) 
        //     {
        //         b[i][j] = Math.max(b[i][j + 1], heightMap[i][j]);
        //     }
        // }

        // for (int j = 0; j < n; j++) 
        // {
        //     c[0][j] = heightMap[0][j];
        //     for (int i = 1; i < m; i++) 
        //     {
        //         c[i][j] = Math.max(c[i - 1][j], heightMap[i][j]);
        //     }
        // }

        // for (int j = 0; j < n; j++) 
        // {
        //     d[m - 1][j] = heightMap[m - 1][j];
        //     for (int i = m - 2; i >= 0; i--) 
        //     {
        //         d[i][j] = Math.max(d[i + 1][j], heightMap[i][j]);
        //     }
        // }

        // for (int i = 0; i < m; i++) 
        // {
        //     for (int j = 0; j < n; j++) 
        //     {
        //         int min1 = Math.min(a[i][j], b[i][j]);
        //         int min2 = Math.min(c[i][j], d[i][j]);
        //         int min3 = Math.min(min1, min2);
        //         totalwater += min3 - heightMap[i][j];
        //     }
        // }

        // return totalwater;
       int m=heightMap.length;
       int n=heightMap[0].length;
       if(m<=2 || n<=2)
       {
        return 0;
       }

       int totalwater=0;
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
       boolean[][] visited=new boolean[m][n];

       for(int i=0;i<n;i++)
       {
            pq.offer(new int[]{heightMap[0][i],0,i});
            visited[0][i]=true;

            pq.offer(new int[]{heightMap[m-1][i],m-1,i});
            visited[m-1][i]=true;
       }
       for(int j=1;j<m-1;j++)
       {
            pq.offer(new int[]{heightMap[j][0],j,0});
            visited[j][0]=true;

            pq.offer(new int[]{heightMap[j][n-1],j,n-1});
            visited[j][n-1]=true;
       }
       int directions[][]={
          {-1,0},
          {1,0},
          {0,-1},
          {0,1}
       };

       while(!pq.isEmpty())
       {
          int[] current=pq.poll();
          int height=current[0];
          int row=current[1];
          int col=current[2];
          for(int[] direction:directions)
          {
              int newrow=row+direction[0];
              int newcol=col+direction[1];
              if(newrow<0 || newcol<0 ||newrow>=m || newcol>=n || visited[newrow][newcol])
              {
                continue;
              }
              visited[newrow][newcol]=true;
              int neiheight=heightMap[newrow][newcol];
              if(neiheight<height)
              {
                totalwater+=height-neiheight;
              }
              int newheight=Math.max(height,neiheight);
              pq.offer(new int[]{
                        newheight,
                        newrow,
                        newcol
                      });

          }
       }
       return totalwater;
    }
}