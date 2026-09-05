class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            int current=asteroids[i];
            while(!stack.isEmpty() && stack.peek()>0 && current<0)
            {
                int top=stack.peek();
                if(Math.abs(top)<Math.abs(current))
                {
                    stack.pop();
                }
                else if(Math.abs(top)==Math.abs(current))
                {
                    stack.pop();
                    current=0;
                    break;
                }
                else
                {
                    current=0;
                    break;
                }
            }
            if(current!=0)
            {
                stack.push(current);
            }
        }
        int[] res=new int[stack.size()];
        for(int i=0;i<stack.size();i++)
        {
            res[i]=stack.get(i);
        }
        return res;
    }
}