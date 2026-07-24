class Solution {
    public void subset(int[] num,List<Integer> ans,List<List<Integer>> res,int i)
    {
        if(i==num.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        ans.add(num[i]);
        subset(num,ans,res,i+1);
        ans.remove(ans.size()-1);
        subset(num,ans,res,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        
        subset(nums,ans,res,0);
        
        return res;
    }
}