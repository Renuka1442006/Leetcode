class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int maxlen=0;
        int i=0;
            int[] hash=new int[26];
            int maxfreq=0;
            for(int j=0;j<n;j++)
            {
                char ch=s.charAt(j);
                hash[ch-'A']++;
                maxfreq=Math.max(maxfreq,hash[ch-'A']);
                int change=(j-i+1)-maxfreq;
                while(change > k)
                {
                    hash[s.charAt(i)-'A']--;
                     i++;

                    change = (j-i+ 1) - maxfreq;
                }
                maxlen=Math.max(maxlen,j-i+1);
            }
        
        return maxlen;
    }
}