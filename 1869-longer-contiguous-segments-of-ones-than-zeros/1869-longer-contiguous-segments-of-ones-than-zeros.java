class Solution {
    public boolean checkZeroOnes(String s) {
        int zerocnt=0;
        int onecnt=0;
        int maxzerocnt=0;
        int maxonecnt=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='1')
            {
                onecnt++;
                maxonecnt=Math.max(onecnt,maxonecnt);
            }
            else
            {
                onecnt=0;
            }
        }
           for(char ch:s.toCharArray())
        {
            if(ch=='0')
            {
                zerocnt++;
                maxzerocnt=Math.max(zerocnt,maxzerocnt);
            }
            else
            {
                zerocnt=0;
            }
        }
        if(maxonecnt > maxzerocnt)
        {
            return true;
        }
        return false;
    }
}