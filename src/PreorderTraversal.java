import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    // preorder: сначала сам узел, потом левое поддерево, потом правое
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val); // узел идёт первым
        helper(node.left, result);
        helper(node.right, result);
    }

    public static void main(String[] args) {
        // дерево [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        PreorderTraversal solution = new PreorderTraversal();
        System.out.println(solution.preorderTraversal(root)); // [1, 2, 3]
    }
}
