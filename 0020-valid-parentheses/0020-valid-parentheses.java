class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                stack.push(ch);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                char c=stack.peek();
                stack.pop();
                if(ch==')' && c=='(')
                {
                   continue;
                }
                else if(ch=='}' && c=='{')
                {
                    continue;
                }
                else if(ch==']' && c=='[')
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
            if(stack.isEmpty())
            {
                return true;
            }
            return false;
        
    }
}