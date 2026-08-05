class Solution {
    boolean isVowel(char ch)
    {
        return ch=='a' || ch=='e' || ch=='i' || ch=='u'  || ch=='o';
    }
    public int countVowelSubstrings(String word) {
        int res=0;
        int n=word.length();
        if(n<5)
        {
            return res;
        }
        for(int i=0;i<n;i++)
        {
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                if(!isVowel(word.charAt(j)))
                {
                    break;
                }
                set.add(word.charAt(j));
                int size=set.size();
                if(size==5)
                {
                    res++;
                }
            }
        }
        return res;
    }
}