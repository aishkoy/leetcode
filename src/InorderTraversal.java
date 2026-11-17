import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    // inorder: левое поддерево -> сам узел -> правое поддерево
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    // обычная рекурсия, значения складываю сразу в общий список
    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        result.add(node.val); // узел попадает между левым и правым
        helper(node.right, result);
    }

    public static void main(String[] args) {
        // дерево [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal solution = new InorderTraversal();
        System.out.println(solution.inorderTraversal(root)); // [1, 3, 2]
    }
}
