class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            String str=words[i];
            int len=str.length();
            boolean found=false;
            for(int j=0;j<len;j++)
            {
                if(str.charAt(j)==x)
                {
                   found=true;
                }
            }
            if(found)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}