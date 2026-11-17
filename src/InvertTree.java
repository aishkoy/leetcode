import java.util.ArrayList;
import java.util.List;

public class InvertTree {

    // в каждом узле меняем местами левого и правого ребёнка,
    // а потом то же самое делаем для детей
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // обычный swap через временную переменную
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // для проверки: вывожу дерево в preorder, так видно, что оно отзеркалилось
    private static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    public static void main(String[] args) {
        // дерево [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertTree solution = new InvertTree();
        TreeNode inverted = solution.invertTree(root);

        List<Integer> list = new ArrayList<>();
        preorder(inverted, list);
        System.out.println(list); // [4, 7, 9, 6, 2, 3, 1]
    }
}
