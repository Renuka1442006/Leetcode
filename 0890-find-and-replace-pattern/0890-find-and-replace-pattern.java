class Solution {
    boolean isMatch(String s,String pattern)
    {
       
           
            HashMap<Character,Character> map1=new HashMap<>();
            HashMap<Character,Character> map2=new HashMap<>();
            int n=s.length();
            int m=pattern.length();
            if(n!=m)
            {
                return false;
            }
            for(int j=0;j<n;j++)
            {
                char c1=pattern.charAt(j);
                char c2=s.charAt(j);
                if(map1.containsKey(c1))
                {
                    if(map1.get(c1)!=c2)
                    {
                        return false;
                    }
                }else
                {
                    map1.put(c1,c2);
                }
                if(map2.containsKey(c2))
                {
                    if(map2.get(c2)!=c1)
                    {
                        return false;
                    }

                }
                else
                {
                    map2.put(c2,c1);
                }

            
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer= new ArrayList<>();
         int n=words.length;
        int m=pattern.length();
        for(int i=0;i<n;i++)
        {
            if(isMatch(words[i],pattern)){
                answer.add(words[i]);
            }
        }
        return answer;
    }
}