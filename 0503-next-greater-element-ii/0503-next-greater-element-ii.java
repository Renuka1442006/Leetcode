class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            res[i]=-1;
        }
        for(int i=0;i<2*n;i++)
        {
            int idx=i%n;
            while(!stack.isEmpty() && nums[idx]>nums[stack.peek()])
            {
                int small=stack.pop();
                res[small]=nums[idx];
            }
            if(i<n)
            {
                stack.push(idx);
            }
        }
        return res;
    }
}