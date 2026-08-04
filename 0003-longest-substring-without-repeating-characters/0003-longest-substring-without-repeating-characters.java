class Solution {
    public int lengthOfLongestSubstring(String s) {
        
       
       int maxlen=0;
       int left=0;
       int hash[]=new int[256];
       for(int right=0;right<s.length();right++)
       {
          hash[s.charAt(right)]++;
          while(hash[s.charAt(right)]>1)
          {
            hash[s.charAt(left)]--;
            left++;
          }
          maxlen=Math.max(maxlen,right-left+1);

       }
       return maxlen;
    }
}