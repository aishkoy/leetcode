import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    // собираем путь строкой, пока спускаемся вниз, а в листе кладём его в ответ
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, "", result);
        return result;
    }

    private void helper(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }
        path = path + node.val;

        // дошли до листа, путь готов
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // строки неизменяемые, так что у каждой ветки будет своя копия пути
        path = path + "->";
        helper(node.left, path, result);
        helper(node.right, path, result);
    }

    public static void main(String[] args) {
        // дерево [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths solution = new BinaryTreePaths();
        System.out.println(solution.binaryTreePaths(root)); // [1->2->5, 1->3]
    }
}
