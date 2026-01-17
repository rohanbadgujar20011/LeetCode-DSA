package Trees;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree543 {

    int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        helper(root);
        return result;

    }

    private int helper(TreeNode root){

        if(root ==null){
            return 0;
        }


        if(root.left != null || root.right != null){
            int left = helper(root.left);
            int right = helper(root.right);

            result = Math.max(result , left + right);
            return Math.max(left , right) + 1;
        }

        else{
            result = Math.max(result , 0);
            return 1;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree543 solution = new DiameterOfBinaryTree543();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
