package common.sort.selection;

/**
 * @author Moosphon
 * @date 2020/4/29 上午11:59
 * @desc 选择排序
 * 原理：选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 *      但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 * 特点：基于比较的原地排序算法，即空间复杂度为O(1)，时间复杂度为O(n^2) [最好、最坏、平均]，属于不稳定算法.
 * e.g.
 *      3   5   2   6   1
 *      1   5   2   6   3
 *      1   2   5   6   3
 *      1   2   3   6   5
 *      1   2   3   5   6
 */
public class SelectionSort {

    public int[] selectionSort(int[] array, int n) {
        if (n < 1) return  null;
        for (int i = 0; i < n; i++) {
            int target = array[i];
            int minIndex = i;
            int j = i;
            for (; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            array[i] = array[minIndex];
            array[minIndex] = target;
        }
        return array;
    }
}
