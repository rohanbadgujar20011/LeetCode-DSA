package Trees;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int s = helper(root);
        return Math.max(result , s);

    }

    int helper(TreeNode node){
        if(node == null){
            return 0;
        }


        int left = helper(node.left);
        int right = helper(node.right);
        if(left < 0){
            left =0;
        }

        if(right <0){
            right =0;
        }

        result  = Math.max(result , left + right + node.val);
        return node.val + Math.max(left , right);


    }

    public static void main(String[] args) {
        MaximumPathSum solution = new MaximumPathSum();

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int maxPath = solution.maxPathSum(root);

        System.out.println("MaxiMum Path is  of Binary Tree: " + maxPath);
    }
}
