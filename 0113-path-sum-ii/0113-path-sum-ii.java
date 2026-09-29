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
     List<List<Integer>> answer=new ArrayList<>();
    void dfs(TreeNode root, int target, List<Integer> path)
    {
        if(root==null)
        {
            return;
        }
        path.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(root.val==target)
            {
                answer.add(new ArrayList<>(path));
            }

        }
        dfs(root.left,target-root.val,path);
        dfs(root.right,target-root.val,path);
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       if(root==null)
       {
        return answer;
       }
       List<Integer> path=new ArrayList<>();
        dfs(root,targetSum,path);
        return answer;
    }
}