class Solution {
    public int smallestNumber(int n, int t) {
        
        int temp=n;
        while(true)
        {
            int x=temp;
            int product=1;
            while(x>0)
            {
                int rem=x%10;
                product*=rem;
                x/=10;
            }
            if(product%t==0)
            {
                return temp;
            }
            temp++;
           
            
        }

        
    }
}