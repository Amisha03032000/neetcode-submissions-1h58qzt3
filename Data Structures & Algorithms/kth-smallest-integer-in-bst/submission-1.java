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
   int cnt=0;
   int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return value;   
    }
    public void inOrder(TreeNode root, int k){

        if(root==null){
            return;
        }

        inOrder(root.left,k);

        if(cnt<k){
            cnt++;
            if(k==cnt){
                value = root.val;
                return;
            }
        }


        inOrder(root.right,k);

    }
}
