package Trees;

import java.util.ArrayList;
import java.util.List;

public class BoundryTraversal {

    public List<Integer> boundary(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left != null || node.right != null) {
            result.add(node.val);
        }

        if (node.left != null) {
            addLeftBoundary(node.left, result);
        } else {
            addLeftBoundary(node.right, result);
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.right != null) {
            addRightBoundary(node.right, result);
        } else {
            addRightBoundary(node.left, result);
        }

        if (node.left != null || node.right != null) {
            result.add(node.val);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Call Boundary Traversal
        BoundryTraversal solution = new BoundryTraversal();
        List<Integer> boundary = solution.boundary(root);
        System.out.println("Boundary Traversal: " + boundary);
    }
}
