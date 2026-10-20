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
    static int preidx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        preidx=n-1;
        return build(inorder,postorder,0,n-1,map);
    }
    TreeNode build(int[] inorder, int[] postorder, int start, int end, Map<Integer,Integer> map)
    {
        if(start> end)
        {
            return null;
        }
        int rootval=postorder[preidx--];
        TreeNode root=new TreeNode(rootval);
        int inidx=map.get(rootval);
        root.right=build(inorder,postorder,inidx+1,end,map);
        root.left=build(inorder, postorder,start,inidx-1,map);
        return root;
    }
}