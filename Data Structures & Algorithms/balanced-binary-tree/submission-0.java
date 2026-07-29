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
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) {
            return true;
        }

        int lt = isHeight(root.left);
        int rt = isHeight(root.right);

        if(Math.abs(lt - rt) > 1){
            return false;
        }

       Boolean ans1 = isBalanced(root.left);
       Boolean ans2 = isBalanced(root.right);

        return ans1 && ans2;
    }
    public int isHeight(TreeNode root){

        if(root == null){
            return 0;
        }
        int lc = isHeight(root.left);
        int rc = isHeight(root.right);

        return 1 + Math.max(lc, rc);
    }
}
