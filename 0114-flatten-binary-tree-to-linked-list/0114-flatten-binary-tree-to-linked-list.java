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
    private void preorder(TreeNode root,ArrayList<TreeNode> nodes)
    {
        if(root==null)
        {
            return;
        }
        nodes.add(root);
        preorder(root.left,nodes);
        preorder(root.right,nodes);
    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> nodes=new ArrayList<>();
        
        preorder(root,nodes);
        if(nodes.isEmpty())
        {
            return;
        }
        TreeNode nroot=nodes.get(0);
        for(int i=1;i<nodes.size();i++)
        {
           
            nroot.right=nodes.get(i);
            nroot.left=null;
            nroot=nroot.right;
            
        }
        System.out.println(nroot);
    }
}