public class MinDepth {

    // тут подвох: глубину считаем только до листа,
    // поэтому если одного ребёнка нет, его "пустую" ветку брать нельзя
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // левого нет -> идём только направо
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // правого нет -> только налево
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // оба ребёнка есть, берём ветку покороче
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        // обычное дерево
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // дерево-"палка", всё уходит вправо
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);

        MinDepth solution = new MinDepth();
        System.out.println(solution.minDepth(root1)); // 2
        System.out.println(solution.minDepth(root2)); // 5
    }
}
