package common.search.binary;

/**
 * @author Moosphon
 * @date 2020/5/3 下午3:46
 * @desc 二分查找
 * 原理：二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。
 *      每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为0。
 * 时间复杂度：O(logn)
 * 场景：1. 有序的顺序表结构（数组）。
 *      2. 二分查找只能用在插入、删除操作不频繁，一次排序多次查找的场景中。
 *         针对动态变化的数据集合，二分查找将不再适用。
 *      3. 如果数据之间的比较操作非常耗时，不管数据量大小，都推荐使用二分查找。
 *      4. 数据量太大不太适用，因为基于数组，需要连续空间。
 */
public class BinarySearch {

    /**
     * 查找给定元素，并返回下标（非递归）
     * @param array 目标已排序的数组
     * @param n     数组的大小
     * @param value 目标数值
     * @return index
     */
    int binarySearch(int[] array, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high) /2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找给定元素，并返回下标（递归）
     * @param array 目标已排序的数组
     * @param n     数组的大小
     * @param value 目标数值
     * @return index
     */
    int binarySearchByRecursion(int[] array, int n, int value) {
        return recursionSearch(array, 0, n-1, value);
    }

    private int recursionSearch(int[] array, int low, int high, int value) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return recursionSearch(array, mid + 1, high, value);
        } else {
            return recursionSearch(array, low, mid - 1, value);
        }
    }
}
