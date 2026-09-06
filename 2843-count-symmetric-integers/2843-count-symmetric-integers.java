class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res=0;
        for(int i=low;i<=high;i++)
        {
            int digitcnt=0;
            int temp=i;
            int lsum=0;
            int rsum=0;
            while(temp>0)
            {
                digitcnt++;
                temp/=10;
            }
            if(digitcnt%2==0)
            {
                temp=i;
                int j=0;
                int half=digitcnt/2;
                while(j<half)
                {
                    int rem=temp%10;
                    rsum+=rem;
                    temp=temp/10;
                    
                    j++;

                }
                while(half<digitcnt)
                {
                    int rem=temp%10;
                    lsum+=rem;
                    temp=temp/10;
                   half++;
                    
                }
                if(lsum==rsum)
                {
                    res++;
                }
            }
        }
        return res;
    }
}