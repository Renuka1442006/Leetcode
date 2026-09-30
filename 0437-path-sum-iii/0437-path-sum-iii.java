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
    
    int dfs(TreeNode root,long targetSum)
    {
        int count=0;
        if(root==null)
        {
            return 0;
        }
        targetSum-=root.val;
        if(targetSum==0)
        {
            count++;
        }
        count+=dfs(root.left,targetSum);
        count+=dfs(root.right,targetSum);
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        //int count=0;
        if(root==null)
        {
            return 0;
        }
       
        int count=dfs(root,targetSum);
        count+=pathSum(root.left,targetSum);
        count+=pathSum(root.right,targetSum);
        return count;
    }
}