package common.sort.bubble;

/**
 * @author Moosphon
 * @date 2020/4/29 上午9:38
 * @desc 冒泡排序相关训练
 * 原理：冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它俩互换。
 *      一次冒泡会让至少一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作。
 * 特点：属于基于比较的原地排序算法，即空间复杂度为O(1)，时间复杂度为O(n^2)，属于稳定算法
 */
public class BubbleSort {

    int[] bubbleSort(int[] array, int n) {
        if (n < 1) return null;
        for (int i = 0; i < n; i++) {
            // 冒泡排序是否提前结束
            boolean stopFlag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 还有数据交换
                    stopFlag = false;
                }
            }
            // 表示没有数据交换，即排序结束了
            if (stopFlag) break;
        }
        return array;
    }
}
