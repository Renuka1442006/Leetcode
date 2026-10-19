class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;

        int ans[]=new int[n];
        
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(arr[i]);
        }
        int idx=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:set)
        {
            map.put(ele,idx);
            idx++;
        }
        for(int i=0;i<n;i++)
        {
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}