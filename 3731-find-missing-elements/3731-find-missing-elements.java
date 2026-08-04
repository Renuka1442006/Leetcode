class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashSet set=new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
            if(num>max)
            {
                max=num;
            }
            if(num<min)
            {
                min=num;
            }
        }
        //Arrays.sort(nums);
        int size=max-min+1;
        if(nums.length==size)
        {
            return res;
        }
        for(int i=min;i<=max;i++)
        {
            if(!set.contains(i))
            {
                res.add(i);
            }
        }
       
       
        return res;
    }
}