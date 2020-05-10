package common.tree;

/**
 * @author Moosphon
 * @date 2020/5/10 下午2:36
 * @desc 二叉树操作
 * TODO: 求二叉树的高度(两种方式)
 */
public class BinaryTree {

    // 前序遍历
    void preOrder(TreeNode root) {
        if (root == null) return;
        printData(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        printData(root);
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {

        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        printData(root);
    }

    private void printData(TreeNode node) {
        System.out.println(node.data + " ");
    }

}
