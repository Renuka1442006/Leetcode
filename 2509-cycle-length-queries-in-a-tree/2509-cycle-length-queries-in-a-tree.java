class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m=queries.length;
        int[] ans=new int[m];
        int idx=0;
        for(int[] edge:queries)
        {
           // int =0;
            int u=edge[0];
            int v=edge[1];
            int cnt=1;
            while (u != v) 
            {
                if (u > v) 
                {
                    u = u / 2;
                } 
                else 
                {
                    v = v / 2;
                }
                cnt++;
            }
            ans[idx]=cnt;
            idx++;
            
        }
        return ans;
    }
}