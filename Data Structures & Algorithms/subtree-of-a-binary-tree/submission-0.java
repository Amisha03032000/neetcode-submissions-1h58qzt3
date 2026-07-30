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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // same tree
        // p tree and q tree
        // p.val == q.val
        // if(dfs(p) && dfs(q)) 


        if(subRoot == null) return true;
        if(root == null) return false;
        if(dfs(root,subRoot) && root.val == subRoot.val) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        }
    public boolean dfs(TreeNode p, TreeNode q){
 
            if(p==null && q==null){
                return true;
            }
            if(p==null || q==null){
                return false;
            }
            if(p.val != q.val){
                return false;
            }

            if(dfs(p.left,q.left) && dfs(p.right, q.right))
            {
                return true;
            }
            return false;
        
    }
}
