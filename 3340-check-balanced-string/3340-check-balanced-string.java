class Solution {
    public boolean isBalanced(String num) {
        int n=num.length();
        int evensum=0;
        int oddsum=0;
        for(int i=0;i<n;i=i+2)
        {
            int no=num.charAt(i)-'0';
            oddsum+=no;
        }
        for(int i=1;i<n;i=i+2)
        {
            int no=num.charAt(i)-'0';
            evensum+=no;
        }
        if(oddsum==evensum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}