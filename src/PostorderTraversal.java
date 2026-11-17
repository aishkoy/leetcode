import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    // postorder: левое поддерево, правое и только потом сам узел
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val); // узел в самом конце
    }

    public static void main(String[] args) {
        // дерево [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        PostorderTraversal solution = new PostorderTraversal();
        System.out.println(solution.postorderTraversal(root)); // [3, 2, 1]
    }
}
