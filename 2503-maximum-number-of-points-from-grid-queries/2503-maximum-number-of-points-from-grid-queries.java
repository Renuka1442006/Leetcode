class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int k=queries.length;
        int[] ans=new int[k];
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];

        int[][] q=new int[k][2];

        for(int i=0;i<k;i++)
        {
            q[i][0]=queries[i];
            q[i][1]=i;
        }
        Arrays.sort(q,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        int directions[][]={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int cnt=0;
        for(int i=0;i<k;i++)
        {
            int query=q[i][0];
            int oriidx=q[i][1];
            while(!pq.isEmpty() && pq.peek()[0] < query)
            {
                int[] current=pq.poll();
                
                cnt++;


                int row=current[1];
                int col=current[2];
               
                    
                    
                   
                    for(int[] direction:directions)
                    {
                        int newrow=row+direction[0];
                        int newcol=col+direction[1];
                        if(newrow<0 || newcol<0 || newrow>=m || newcol>=n || visited[newrow][newcol])
                        {
                            continue;
                        }
                        visited[newrow][newcol]=true;
                        
                            pq.offer(new int[]{
                                grid[newrow][newcol],
                                newrow,
                                newcol
                            });
                        
                    
                    }
            }
            ans[oriidx]=cnt;
            //pq.clear();
        }
        return ans;
    }
}