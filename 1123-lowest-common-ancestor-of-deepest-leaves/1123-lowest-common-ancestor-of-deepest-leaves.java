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
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null)
        {
            return root;
        } 
        int left=height(root.left);
        int right=height(root.right);
        if(left==right)
        {
            return root;
        }
        if(left > right)
        {
            return lcaDeepestLeaves(root.left);

        }
        return lcaDeepestLeaves(root.right);

        
    }
}