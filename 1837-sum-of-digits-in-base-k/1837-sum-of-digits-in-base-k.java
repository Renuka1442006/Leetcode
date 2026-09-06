class Solution {
    public int sumBase(int n, int k) {
        int basenum=0;
        while(n>0)
        {
            int rem=n%k;
            basenum=basenum*10+rem;
            n=n/k;
        }
        int ans=0;
        while(basenum>0)
        {
            int rem=basenum%10;
            ans+=rem;
            basenum/=10;
        }
        return ans;
    }
}