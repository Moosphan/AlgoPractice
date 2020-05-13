package common.sort.heap;

/**
 * @author Moosphon
 * @date 2020/5/13 下午8:56
 * @desc 堆的基本操作（增删查和排序）
 * 特点：1. 堆是一个完全二叉树；
 *      2. 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 * T(n): 插入和删除操作都会涉及到"堆化"过程，时间复杂度O(logn)，而堆排序的时间复杂度稳定为：O(nlogn)，属于原地不稳定排序算法。
 * Question: 实现一个堆(大顶堆)和实现排序，从大到小排列。
 */
public class HeapSort {

    private int[] a;        // 存储堆的数组
    private int n;          // 堆中最多存储的元素数量
    private int count;      // 堆中已存储的元素个数

    public HeapSort(int capacity) {
        a = new int[capacity + 1]; // 从下标1开始存储
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 往堆中插入元素（采用自下而上堆化法）
     * @param value 待插入的元素
     */
    public void insert(int value) {
        if (count >= n) return;
        count++;
        a[count] = value;
        int i = count;
        // 自下而上堆化
        while (i / 2 > 0 && a[i] > a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶的元素（最大值）
     * 采用自上而下堆化法（将最后一个元素替换最大的元素）
     */
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    /**
     * 堆排序（建堆+排序）
     */
    public void heapSort() {
        buildHeap();
        int k = count;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    /**
     * 建堆过程，即将普通数组转为堆的数据结构（实际上，对于完全二叉树来说，下标从 2n​+1 到 n 的节点都是叶子节点）
     * 建堆的时间复杂度就是 O(n)。
     */
    private void buildHeap() {
        for (int i = count; i >= 1; i--) {
            heapify(a, count, i);
        }
    }

    /**
     * 自上而下堆化过程
     * @param a      目标堆
     * @param count  堆中的元素数量
     * @param i      当前堆化位置
     */
    private void heapify(int[] a, int count, int i) {
        while (true) {
            int maxPosition = i;
            if (i*2 <= n && a[i*2] > a[i]) maxPosition = i*2;
            if (i*2+1 <= n && a[i*2+1] > a[maxPosition]) maxPosition = i*2+1;
            if (maxPosition == i) break;
            swap(a, i, maxPosition);
            i = maxPosition;
        }
    }

    // 数组元素交换
    private void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
