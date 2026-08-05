class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxlen=0;
        for(int i=0;i<n;i++)
        {
            int[] hash=new int[256];
            for(int j=i;j<n;j++)
            {
                if(hash[s.charAt(j)]>=1){
                    break;
                }
                int len=j-i+1;
                maxlen=Math.max(len,maxlen);
                hash[s.charAt(j)]++;
            }
        }
       return maxlen;
    //    int maxlen=0;
    //    int left=0;
    //    int hash[]=new int[256];
    //    for(int right=0;right<s.length();right++)
    //    {
    //       hash[s.charAt(right)]++;
    //       while(hash[s.charAt(right)]>1)
    //       {
    //         hash[s.charAt(left)]--;
    //         left++;
    //       }
    //       maxlen=Math.max(maxlen,right-left+1);

    //    }
    //    return maxlen;
    }
}