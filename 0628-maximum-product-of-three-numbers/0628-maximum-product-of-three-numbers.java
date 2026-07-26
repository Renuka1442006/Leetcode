class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int n1=nums[n-1];
        int max=Integer.MIN_VALUE;
        int product=1;
        for(int i=1;i<n-1;i++)
        {
            product=n1*nums[i-1]*nums[i];
            max=Math.max(product,max);
        }
        return max;
    }
}