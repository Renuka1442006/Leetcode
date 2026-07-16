class Solution {
    ArrayList<Integer> arr=new ArrayList<>();
    public void mergeSort(int[] nums,int start, int end)
    {
        int mid=start+(end-start)/2;
        if(start < end)
        {
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public void merge(int[] nums, int start, int mid, int end)
    {
        int i=start;
        int j=mid+1;
          ArrayList<Integer> arr=new ArrayList<>();
        while(i<=mid && j<=end)
        {
            if(nums[i]<nums[j])
            {
                arr.add(nums[i]);
                i++;
            }
            else{
                arr.add(nums[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            arr.add(nums[i]);
            i++;
        }
        while(j<=end)
        {
            arr.add(nums[j]);
            j++;
        }
        for(int k=0;k<arr.size();k++)
        {
            nums[k+start]=arr.get(k);
        }
    }
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        mergeSort(nums,start,end);
        
        
        return nums;
    }
}