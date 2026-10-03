/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer=new ArrayList<>();
        if(root==null)
        {
            return answer;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        answer.add(root.val);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=queue.remove();
                if(temp.left!=null)
                {
                    queue.offer(temp.left);
                    level.add(temp.left.val);

                }
                if(temp.right!=null)
                {
                    queue.offer(temp.right);
                    level.add(temp.right.val);
                }
            } 
            int s=level.size();
            if(s>0)
            {
                     int value=level.remove(s-1);
            answer.add(value);
            }
           

        }
        return answer;
    }
}