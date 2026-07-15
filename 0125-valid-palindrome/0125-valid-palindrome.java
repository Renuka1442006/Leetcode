class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(c1!=c2)
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}