class Solution {

    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
       
        int ans=0;
        for(int num:set)
        {
        
            if(!set.contains(num-1))
            {
                int current=num;
               
                while(set.contains(current+1))
                {
                    current++;
                }
                ans=Math.max(ans,current-num+1);
            }
            
        }     
         return ans;
    }
}