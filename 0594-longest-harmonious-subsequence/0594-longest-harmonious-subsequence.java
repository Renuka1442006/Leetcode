class Solution {

    public int findLHS(int[] nums) {
       // int n=nums.length;
      HashMap<Integer,Integer> map=new HashMap<>();
      for(int num:nums)
      {
        map.put(num,map.getOrDefault(num,0)+1);
      }
      int res=0;
      for(int n:map.keySet())
      {
        if(map.containsKey(n+1))
        {
            int max=map.get(n)+map.get(n+1);
            res=Math.max(res,max);
            
        }
        
      }
      return res;
    }
}