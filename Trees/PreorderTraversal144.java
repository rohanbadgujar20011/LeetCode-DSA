package Trees;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class PreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorder(root , result);
        return result;
    }

    private void preorder(TreeNode node , List<Integer> result) {

        if(node ==null){
            return ;
        }

        result.add(node.val);

        if (node.left ==null && node.right ==null){
            return;
        }

        preorder(node.left , result);
        preorder(node.right , result);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        PreorderTraversal144 solution = new PreorderTraversal144();
        List<Integer> result = solution.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);

    }
}



