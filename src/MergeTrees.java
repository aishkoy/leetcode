import java.util.ArrayList;
import java.util.List;

public class MergeTrees {

    // сливаю второе дерево в первое, новое дерево не создаю
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // если с одной стороны узла нет, просто берём поддерево с другой
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // узел есть в обоих деревьях, складываем значения
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    // печать в preorder вместе с null, чтобы была видна структура дерева
    private static void print(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        print(node.left, list);
        print(node.right, list);
    }

    public static void main(String[] args) {
        // дерево [1,3,2,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        // дерево [2,1,3,null,4,null,7]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        // должно получиться [3,4,5,5,4,null,7]
        MergeTrees solution = new MergeTrees();
        TreeNode merged = solution.mergeTrees(root1, root2);

        List<String> list = new ArrayList<>();
        print(merged, list);
        System.out.println(list);
    }
}
