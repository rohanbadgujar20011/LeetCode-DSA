package Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal94 {

    public static  List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorder(root , result);
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> result) {

        if(node ==null){
            return ;
        }



        if (node.left ==null && node.right ==null){
            result.add(node.val);
            return;
        }

        inorder(node.left , result);
        result.add(node.val);
        inorder(node.right , result);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal94 solution = new InorderTraversal94();
        List<Integer> result = inOrderTraversal(root);


        System.out.println("InOrder Traversal: " + result);

    }
}
