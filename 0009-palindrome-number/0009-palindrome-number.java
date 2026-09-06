class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int rev=0;
        int temp=x;
        while(x>0)
        {
            int rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        if(temp==rev)
        {
            return true;
        }
        return false;
    }
}