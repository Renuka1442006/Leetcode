class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        int maxlen=0;
        int freq[]=new int[26];
        for(int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            freq[ch-'a']++;
            while(freq[ch-'a']>2)
            {
                freq[s.charAt(left)-'a']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}