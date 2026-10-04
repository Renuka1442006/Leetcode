class Solution {
    public boolean canBeValid(String s, String locked) {

        int n = s.length();
        if (n % 2 == 1) 
        {
            return false;
        }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> flexible = new Stack<>();
        for (int i = 0; i < n; i++) 
        {
            if (locked.charAt(i) == '0') 
            {
                flexible.push(i);
            }
            else if (s.charAt(i) == '(') 
            {
                open.push(i);
            }
            else 
            {
                if (!open.isEmpty()) 
                {
                    open.pop();
                }
                else if (!flexible.isEmpty()) {
                    flexible.pop();
                }
                else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !flexible.isEmpty()) 
        {
            int openIndex = open.pop();
            int flexibleIndex = flexible.pop();
            if (flexibleIndex < openIndex) 
            {
                return false;
            }
        }
        if (!open.isEmpty()) 
        {
            return false;
        }
        return true;
    }
}