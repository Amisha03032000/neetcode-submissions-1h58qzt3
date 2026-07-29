class Solution {
    int totaldiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
     
        //we will use the simple recursion
       heightOfBT(root);



        return totaldiameter;
    }

    public int heightOfBT(TreeNode root){

        if(root == null){
            return 0;
        }

        int lc = heightOfBT(root.left);
        int rc = heightOfBT(root.right);

        totaldiameter = Math.max(totaldiameter, lc+rc);
        return 1 + Math.max(lc, rc);
    }

}





    // iterative method
    //     if (root == null) {
    //         return 0;
    //     }

    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);

    //     int diameter = 0;

    //     while (!queue.isEmpty()) {

    //         TreeNode curr = queue.poll();

    //         int leftHeight = height(curr.left);
    //         int rightHeight = height(curr.right);

    //         diameter = Math.max(diameter, leftHeight + rightHeight);

    //         if (curr.left != null) {
    //             queue.offer(curr.left);
    //         }

    //         if (curr.right != null) {
    //             queue.offer(curr.right);
    //         }
    //     }

    //     return diameter;
    // }

    // // Height using BFS
    // private int height(TreeNode root) {

    //     if (root == null) {
    //         return 0;
    //     }

    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);

    //     int height = 0;

    //     while (!q.isEmpty()) {

    //         int size = q.size();

    //         for (int i = 0; i < size; i++) {

    //             TreeNode node = q.poll();

    //             if (node.left != null) {
    //                 q.offer(node.left);
    //             }

    //             if (node.right != null) {
    //                 q.offer(node.right);
    //             }
    //         }

    //         height++;
    //     }

    //     return height;
    // }
//}