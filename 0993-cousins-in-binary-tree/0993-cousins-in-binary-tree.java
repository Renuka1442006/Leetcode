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
    TreeNode xParent=null;
    TreeNode yParent=null;
    int xdepth=-1;
    int ydepth=-1;

    public void dfs(TreeNode root,TreeNode parent, int level, int x,int y)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==x)
        {
            xParent=parent;
            xdepth=level;
        }
        if(root.val==y)
        {
            yParent=parent;
            ydepth=level;
        }
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);
        return xdepth==ydepth && xParent!=yParent;
    }
}