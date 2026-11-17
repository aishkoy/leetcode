public class MaxDepth {

    // глубина = сам узел (+1) и глубина самого длинного из поддеревьев
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // пустое дерево, глубина 0
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // дерево [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepth solution = new MaxDepth();
        System.out.println(solution.maxDepth(root)); // 3
    }
}
