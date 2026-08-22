class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int temp=n;
        int prod=1;
        while(temp>0)
        {
            int rem=temp%10;
            sum=sum+rem;
            prod=prod*rem;
            temp=temp/10;

        }
        int res=sum+prod;
        if(n%res==0)
        {
            return true;
        }
        return false;
    }
}