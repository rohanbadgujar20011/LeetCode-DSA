package Trees;


//Given a binary tree, determine if it is height-balanced.


public class BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        return checkheight(root) != -1;
    }

    private int checkheight(TreeNode root) {

        if (root == null) return  0;


        int left = checkheight(root.left);
        if (left ==-1) return  -1;

        int right = checkheight(root.right);
        if (right == -1 ) return  -1;

        if (Math.abs(left - right) > 1){
            return -1;
        }

        return  1 + Math.max(left , right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BalancedBinaryTree110 solution = new BalancedBinaryTree110();
        System.out.println(solution.isBalanced(root));

    }
}
