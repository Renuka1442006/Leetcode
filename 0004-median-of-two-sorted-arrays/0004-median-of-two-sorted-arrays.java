class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0.0000;
        int i=0;
        int j=0;
        int m=nums1.length;
        int n=nums2.length;
        ArrayList<Integer> arr=new ArrayList<>();
        while(i<m && j<n)
        {
            if(nums1[i] < nums2[j])
            {
                arr.add(nums1[i]);
                i++;
            }
            else
            {
                arr.add(nums2[j]);
                j++;
            }
        }
        while(i<m)
        {
            arr.add(nums1[i]);
            i++;
        }
        while(j<n)
        {
            arr.add(nums2[j]);
            j++;
        }
        int size=arr.size();
        if(size%2!=0)
        {
            ans=arr.get(size/2);
        }
        else
        {
            int sum=arr.get(size/2)+arr.get(size/2-1);
            ans=(double)sum/2;
        }
        return ans;
    }
}