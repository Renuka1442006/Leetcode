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
    public void inorder(TreeNode root,List<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
       
        int n=queries.size();

        
        inorder(root,ans);
        
        for(int q:queries)
        {
             List<Integer> pair=new ArrayList<>();
           int left=0;
           int right=ans.size()-1;
           
           while(left <= right)
           {
               int mid = left+(right-left)/2;
               if(ans.get(mid)==q)
               {
                 left=mid;
                 right=mid;
                  break;
               }
               else if(ans.get(mid)<q)
               {
                    left=mid+1;
               }
               else
               {
                right=mid-1;
               }

           }
           int mini = (right >= 0) ? ans.get(right) : -1;
          int maxi = (left < ans.size()) ? ans.get(left) : -1;
          res.add(Arrays.asList(mini,maxi));
        }
        return res;
    }

}