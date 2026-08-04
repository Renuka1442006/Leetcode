class Solution {
    public void reverse(int[] nums, int left, int right)
    {
        while(left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int i=0;
        int n=nums.length;
        k=k%n;
        reverse(nums,i,n-1);
        reverse(nums,i,k-1);
        reverse(nums,k,n-1);

    }
}