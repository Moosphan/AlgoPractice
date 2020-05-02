package common.sort.quick;

/**
 * @author Moosphon
 * @date 2020/5/2 下午2:12
 * @desc 快速排序
 * 原理：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 *      我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。
 *      经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 *      前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 *
 * 特点：基于分治思想和递归，不稳定、原地的排序算法。
 *      递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
 *      终止条件：p >= r
 *
 * 时间复杂度：最好是O(nlogn)，最坏是O(n^2)，平均为O(nlogn)
 * 空间复杂度：O(1)
 */
public class QuickSort {

    public int[] sort(int[] array, int n) {
        if (n < 1) return null;
        quickSort(array, 0, n-1);
        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int position = partition(array, start, end);
        quickSort(array, start, position-1);
        quickSort(array, position+1, end);
    }

    // 返回pivot基准值的下标
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                // 碰到较小值则交换
                int temp = array[left];
                array[left++] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[left];
        array[left] = pivot;
        array[end] = temp;
        return left;
    }
}
