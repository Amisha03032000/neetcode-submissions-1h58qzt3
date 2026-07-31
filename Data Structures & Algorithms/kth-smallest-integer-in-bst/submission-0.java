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
    Queue<Integer> q = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);

        
            for(int i=0;i<k-1;i++){
                q.poll();
            }

   
       return q.poll();
        
    }
    public void inOrder(TreeNode root){

        if(root==null){
            return;
        }

        inOrder(root.left);
        q.add(root.val);
        inOrder(root.right);

    }
}
