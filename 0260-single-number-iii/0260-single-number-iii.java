class Solution {
    public int[] singleNumber(int[] nums) {
        

        int xor=0;
        for(int num:nums)
        {
            xor^=num;
        }
        int rightMostBit=xor & (-xor); 
        int n1=0;
        int n2=0;
        for(int num:nums)
        {
            if((num & rightMostBit)!=0)
            {
                n1^=num;

            }
            else
            {
                n2^=num;
            }
           
        }
        return new int[]{n1,n2};
    }
}