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
    
    public int maxdown(TreeNode root,int[] maxvalue)
    {
        if(root==null)
        {
            return 0;
        }
       int leftsum=Math.max(0,maxdown(root.left,maxvalue));
       int rightsum=Math.max(0,maxdown(root.right,maxvalue));
       maxvalue[0]=Math.max(maxvalue[0],(leftsum+rightsum+root.val));
       return Math.max(leftsum,rightsum)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int maxvalue[]=new int[1];
        maxvalue[0]=Integer.MIN_VALUE;
        if(root==null)
        {
            return 0;
        }  
        int t=maxdown(root,maxvalue);
        return maxvalue[0];
        
    }
}