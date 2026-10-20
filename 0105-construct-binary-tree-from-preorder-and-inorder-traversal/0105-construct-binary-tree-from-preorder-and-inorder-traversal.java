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
        int preidx=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return build(preorder,inorder,0,n-1);
    }
    TreeNode build(int[] preorder,int[] inorder,int start,int end)
    {
        if(start > end)
        {
            return null;
        }
        int rootval=preorder[preidx];
        preidx++;
        TreeNode root=new TreeNode(rootval);
        int inidx=start;
        while(inorder[inidx]!=rootval)
        {
            inidx++;
        }
        root.left=build(preorder,inorder,start,inidx-1);
        root.right=build(preorder,inorder,inidx + 1,end);
        return root;
    }
}