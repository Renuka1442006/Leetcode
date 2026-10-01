/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    public void buildParent(TreeNode root,TreeNode parent)
    {
        if(root==null)
        {
            return;
        }
        map.put(root,parent);
        buildParent(root.left,root);
        buildParent(root.right,root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer=new ArrayList<>();
        buildParent(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance=0;
        while(!queue.isEmpty())
        {
            if(distance==k)
            {
                break;
            }
            int size=queue.size();
            while(size-- > 0)
            {
                TreeNode current=queue.poll();

                if(current.left!=null && visited.add(current.left))
                {
                    queue.offer(current.left);
                }
                if(current.right!=null && visited.add(current.right))
                {
                    queue.offer(current.right);
                }
                if(map.get(current)!=null && visited.add(map.get(current)))
                {
                    queue.offer(map.get(current));
                }

            }
            distance++;
        }
        while(!queue.isEmpty())
        {
            answer.add(queue.poll().val);
        }
        return answer;
        
    }
}