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
    boolean isMirror(TreeNode rootleft,TreeNode rootright)
    {
        if(rootleft==null && rootright==null)
        {
            return true;
        }
        if(rootleft==null && rootright!=null || rootleft!=null && rootright==null)
        {
            return false;
        }
        if(rootleft.val!=rootright.val)
        {
            return false;
        }
        return isMirror(rootleft.left,rootright.right) && isMirror(rootleft.right,rootright.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return isMirror(root.left,root.right);
    }
}