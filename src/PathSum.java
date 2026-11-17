public class PathSum {

    // спускаемся вниз и каждый раз вычитаем значение узла из targetSum,
    // в листе остаётся проверить, что осталось ровно его значение
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // лист, путь закончился
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int rest = targetSum - root.val; // сколько ещё надо набрать
        return hasPathSum(root.left, rest) || hasPathSum(root.right, rest);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum solution = new PathSum();
        System.out.println(solution.hasPathSum(root, 22)); // true, путь 5->4->11->2
        System.out.println(solution.hasPathSum(root, 100)); // false
    }
}
