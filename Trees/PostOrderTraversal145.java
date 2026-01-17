package Trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal145 {

    public  List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        postOrder(root , result);
        return result;
    }

    private  void postOrder(TreeNode node, List<Integer> result) {

        if(node ==null){
            return ;
        }


        postOrder(node.left , result);
        postOrder(node.right , result);
        result.add(node.val);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        PostOrderTraversal145 solution = new PostOrderTraversal145();
        List<Integer> result = solution.postOrderTraversal(root);


        System.out.println("PostOrder Traversal: " + result);

    }
}
