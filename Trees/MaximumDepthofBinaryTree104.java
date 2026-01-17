package Trees;



public class MaximumDepthofBinaryTree104 {

    public int maxDepth(TreeNode root){
        return helper(root);
    }

    int helper(TreeNode node){

        if (node == null){
            return  0;
        }

        if (node.left != null && node.right != null){
            return  1 + Math.max(helper(node.left) , helper(node.right));
        }
        else {
            return  1 ;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthofBinaryTree104 solution = new  MaximumDepthofBinaryTree104();
        System.out.println(solution.helper(root));

    }
}
