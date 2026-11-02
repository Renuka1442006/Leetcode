class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        int[] newarr=new int[n];
        int j=0;
        for(int i=0; i<n && j<n;i++)
        {
            newarr[j]=arr[i];
            j++;
            if(arr[i]==0 && j<n)
            {
                newarr[j]=0;
                j++;
            }
        }
        for(int i=0;i<n;i++)
        {
            arr[i]=newarr[i];
        }
    }
}