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

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode root, int row, int col) {
        this.node = root;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple t = queue.poll();

            TreeNode temp = t.node;
            int x = t.row;
            int y = t.col;

            // Create column if it doesn't exist
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }

            // Create row if it doesn't exist
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(temp.val);

            if (temp.left != null) {
                queue.offer(new Tuple(temp.left, x - 1, y + 1));
            }

            if (temp.right != null) {
                queue.offer(new Tuple(temp.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {

            List<Integer> current = new ArrayList<>();

            // Read row by row
            for (PriorityQueue<Integer> pq : ys.values()) {

                // Values at the same row and column
                // must be taken in sorted order
                while (!pq.isEmpty()) {
                    current.add(pq.poll());
                }
            }

            ans.add(current);
        }

        return ans;
    }
}