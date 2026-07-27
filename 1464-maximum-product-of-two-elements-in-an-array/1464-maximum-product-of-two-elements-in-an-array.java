class Solution {
    public int maxProduct(int[] nums) {
        int largest=0;
        int secondlargest=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>=largest)
            {
                secondlargest=largest;
                largest=nums[i];
            }
            else if(nums[i]>= secondlargest && nums[i]!=largest)
            {
                secondlargest=nums[i];
            }
        }
        return (largest-1)*(secondlargest-1);
    }
}