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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
       ans.add(new ArrayList<>(Arrays.asList(root.val)));
        int k=0;
        while(!queue.isEmpty())
        {
            List<Integer> level=new ArrayList<>();

            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode current=queue.remove();
                if(current.left!=null)
                {
                    queue.add(current.left);
                    level.add(current.left.val);
                }
                if(current.right!=null)
                {
                    queue.add(current.right);
                    level.add(current.right.val);
                }
            }
            if(k%2==0)
            {
                Collections.reverse(level);
                ans.add(level);
            }
            else
            {
                ans.add(level);
            }
            k++;
        }
        ans.remove(ans.size()-1);
        return ans;
    }
}