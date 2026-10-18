class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> answer=new ArrayList<>();
        List<Integer> seen=new ArrayList<>();

        int k=0;
        int n=nums.length;
       
       for(int i=0;i<n;i++)
       {
        if(nums[i]>0)
        {
            seen.add(0,nums[i]);
            k=0;
        }
        else
        {
            k++;
           if(k<=seen.size())
        {
            answer.add(seen.get(k-1));
        }    
        else
        {
            answer.add(-1);
        }
        }
        
       }
        
        return answer;
    }
}