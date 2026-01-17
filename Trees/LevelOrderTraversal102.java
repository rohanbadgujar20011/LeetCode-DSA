package Trees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }


    void helper(TreeNode node ,int level , List<List<Integer>> ans ){

        if (node == null){
            return;
        }

        if(level == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(node.val);

        helper(node.left , level + 1 , ans);
        helper(node.right , level + 1 , ans);

    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        LevelOrderTraversal102 solution = new  LevelOrderTraversal102();
        List<List<Integer>> list = solution.levelOrder(root);

        System.out.println(list);


    }


}
