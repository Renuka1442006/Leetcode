class Solution {
    public int largestRectangleArea(int[] heights) {
    //    Stack<Integer> stack=new Stack<>();
    //    int res=0;
    //    int n=heights.length;
    //    for(int i=0;i<n;i++)
    //    {
    //         //int maxrec=Integer.MIN_VALUE;
    //         int current=heights[i];
    //         if(!stack.isEmpty())
    //         {
    //             int top=stack.peek();
    //             if(top<=current)
    //             {
    //                 res=Math.max(res,Math.max(current,top+top));
                   
    //             }
               
                
    //         }
    //         else
    //         {
    //             //stack.push(current);
    //             res=Math.max(res,current);
    //         }
    //         stack.push(current);
    //    } 
    //    return res;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > currentHeight) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}