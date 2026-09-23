class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int m=intervals.length;
        List<int[]> list=new ArrayList<>();
        
        //int n=intervals[0].length;
       // int[][] ans=new int[m][n];
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<m;i++)
        {
            if(intervals[i][0]<=end)
            {
                end=Math.max(end,intervals[i][1]);
            }
            else
            {
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
}