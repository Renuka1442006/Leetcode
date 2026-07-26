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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode nn=new TreeNode(val);
        if(root==null)
        {
            root=nn;
            return root;
        }
        TreeNode temp=root;
        TreeNode parent=null;
        while(temp!=null)
        {
            parent=temp;
            if(temp.val<val)
            {
                temp=temp.right;
                
            }
            else
            {
                temp=temp.left;
            }
        }
        if(val<parent.val)
        {
            parent.left=nn;
        }
        else
        {
            parent.right=nn;
        }
        return root;
    }
}