class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        int len=words.length;
        int wordlen=words[0].length();
        int winlen=len*wordlen;

        for(int i=0;i<len;i++)
        {
            String str=words[i];
            map.put(str,map.getOrDefault(str,0)+1);
        }
       
        for(int i=0;i<wordlen;i++)
        {
            int left=i;
            int right=i;
            int count=0;
             HashMap<String, Integer> current=new HashMap<>();
            while(right+wordlen<=s.length())
            {
                String word=s.substring(right,right+wordlen);
                right+=wordlen;
                if(!map.containsKey(word))
                {
                    left=right;
                    current.clear();
                    count=0;
                    continue;

                }
                current.put(word,current.getOrDefault(word,0)+1);
                count++;
                while(current.get(word)>map.get(word))
                {
                    String leftWord =s.substring(left, left + wordlen);
                    current.put(leftWord,current.get(leftWord) - 1);
                    left += wordlen;
                    count--;
                }
                if(count==words.length)
                {
                    res.add(left);
                    String leftWord =s.substring(left, left + wordlen);

                    current.put(leftWord,current.get(leftWord) - 1);
                    left += wordlen;
                    count--;
                }
            }
        }
        return res;
    }
}