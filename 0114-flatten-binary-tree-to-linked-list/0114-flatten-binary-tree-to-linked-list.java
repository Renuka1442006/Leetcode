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

 //Brute force: preorder traversal-> store in arraylist and add the elements one by one
class Solution {
    TreeNode rightMost(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        TreeNode curr=root;
        while(curr != null)
        {
            if(curr.left!=null)
            {
                TreeNode temp=curr.right;
                curr.right=curr.left;
                curr.left=null;
                TreeNode rMost=rightMost(curr.right);
                rMost.right=temp;
            }
            curr=curr.right;
        }
    }
}