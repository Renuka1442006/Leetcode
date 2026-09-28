class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int maxdepth=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
           // int cnt=0;
            if(ch=='(')
            {
                stack.push(ch);
            }
            else if(ch==')')
            {
                
                
                
                maxdepth=Math.max(maxdepth,stack.size());
                stack.pop();
            }
            else {
                continue;
            }
        }
        return maxdepth;
    }
}