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
    ArrayList<Integer> nodes = new ArrayList<>();

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int n = nodes.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = nodes.get(left) + nodes.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}