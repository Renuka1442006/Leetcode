class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++)
        {
           char ch=s.charAt(right);
           if(set.contains(ch))
           {
                while(s.charAt(left)!=ch && left<right)
                {
                    set.remove(s.charAt(left));
                    left=left+1;
                    
                }
                left=left+1;
           }
           set.add(ch);
            int len=right-left+1;
            maxlen=Math.max(maxlen,len);
            
        }
        return maxlen;
    }
}