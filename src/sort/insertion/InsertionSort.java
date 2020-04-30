package sort.insertion;

/**
 * @author Moosphon
 * @date 2020/4/29 上午11:15
 * @desc 插入排序
 * 原理：我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就是数组的第一个元素。
 *      插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 *      重复这个过程，直到未排序区间中元素为空，算法结束。
 * 特点：基于比较的原地排序算法，即空间复杂度为O(1)，时间复杂度为O(n^2) [平均]，最好时间复杂度为O(n)，属于稳定算法
 * e.g.
 *                           移动次数
 *      3|   5   2   6   1      0
 *      3    5|  2   6   1      0
 *      2    3   5|  6   1      2
 *      2    3   5   6   1      0
 *      1    2   3   5   6      4
 *
 *      移动次数 = 逆序度 = 满有序度 - 初始序列有序度 = n(n-1)/2 - 4 = 6
 */
public class InsertionSort {

    int[] insertionSort(int[] array, int n) {
        if (n < 1) return  null;
        for (int i = 1; i < n; i++) {
            int target = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > target) {
                    // 依次往后移动
                    array[j+1] = array[j];
                } else  {
                    break;
                }
            }
            // 在正确位置插入目标数据
            array[j+1] = target;
        }
        return array;
    }
}
