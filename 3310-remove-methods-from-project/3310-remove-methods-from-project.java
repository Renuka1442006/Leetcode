class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> graph, int k,boolean[] visited)
    {
        if(visited[k])
        {
            return;
        }
        visited[k]=true;
        for(int neighbor:graph.get(k))
        {
            if(!visited[neighbor])
            {
                dfs(graph,neighbor,visited);
            }
        }


    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        boolean[] visited=new boolean[n];
        
       // int len=invocation.length;
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] e:invocations)
        {
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
        }
        dfs(graph,k,visited);
         for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!visited[u] && visited[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

       List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            if (!visited[i]) 
            {
                ans.add(i);
            }
        }
        return ans;
    }
}