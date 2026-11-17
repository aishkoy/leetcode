public class SumOfLeftLeaves {

    // нужны только левые листья, т.е. листья, которые висят слева от родителя
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;

        // смотрим на левого ребёнка: если он лист, забираем его значение
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // и дальше ищем левые листья в обоих поддеревьях
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        // дерево [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        System.out.println(solution.sumOfLeftLeaves(root)); // 24 (9 + 15)
    }
}
