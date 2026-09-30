class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
       // List<Integer> ans=new ArrayList<>();
       int[] ans=new int[n];
        Stack<Character> stack=new Stack<>();
        int depth=0;
        for(int i=0;i<n;i++)
        {
            char ch=seq.charAt(i);
            if(ch=='(')
            {
              
               ans[i]=depth%2; 
                depth++;
            }
            else
            {
                 depth--;
                ans[i]=depth%2;
                  
            }
        }
        return ans;
    }
}