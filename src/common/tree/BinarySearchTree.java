package common.tree;

/**
 * @author Moosphon
 * @date 2020/5/10 下午3:14
 * @desc 二叉查找树(二叉排序树)
 * 定义：在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
 * TODO: 1.如何快速查找最大节点 2. 快速查找前驱节点
 */
public class BinarySearchTree {

    private TreeNode tree;

    // 查找操作
    public TreeNode find(int value) {
        TreeNode p = tree;
        while (p != null) {
            if (p.data > value) {
                p = p.left;
            } else if (p.data < value) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 插入操作
    public void insert(int value) {
        if (tree == null) {
            tree = new TreeNode(value);
            return;
        }
        TreeNode p = tree;
        while (p != null) {
            if (value > p.data) {
                // 插入到右子树
                if (p.right == null) {
                    p.right = new TreeNode(value);
                    return;
                }
                p = p.right;
            } else if (value < p.data) {
                // 插入到左子树
                if (p.left == null) {
                    p.left = new TreeNode(value);
                    return;
                }
                p = p.left;
            }
        }
    }

    // 删除操作
    // 分情况：1.没有子节点 2.只有一个子节点 3.有两个子节点
    // 情况2中：我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
    // 然后再删除掉这个最小节点，因为最小节点肯定没有左子节点.(李代桃僵)
    public void delete(int value) {
        TreeNode p = tree;
        TreeNode pp = tree;
        while (p != null && p.data != value) {
            pp = p;
            if (p.data > value) p = p.left;
            else p = p.right;
        }
        if (p == null) return; // 未找到目标节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点(无左子节点)
            TreeNode rightMin = p.right;
            TreeNode pMin = p;
            while (rightMin != null) {
                pMin = rightMin;
                rightMin = rightMin.left;
            }
            p.data = rightMin.data; // 替换最初待删除位置的值
            p = rightMin; // 指向新的对象 (它们内存地址不同，也就是说，p和最初删除位置的节点已经没有任何关系了，这里它只代表需要被删除的节点)
            pp = pMin; // 这里需要知道rightMin的父节点
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode deleteChild;
        if (p.right != null) {
            deleteChild = p.right;
        } else if (p.left != null) {
            deleteChild = p.left;
        } else {
            deleteChild = null;
        }

        // 直接将删除节点的后续节点移到删除节点父节点的后面(所以这里需要一个父节点变量)
        if (pp == null) tree = deleteChild; // 删除的是根节点
        else if (pp.left == p) {
            pp.left = deleteChild;
        } else {
            pp.right = deleteChild;
        }

    }

    // 寻找最小值节点
    public TreeNode findMin() {
        if (tree == null) return null;
        TreeNode p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    // 寻找最大值节点
    public TreeNode findMax() {
        if (tree == null) return null;
        TreeNode p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
