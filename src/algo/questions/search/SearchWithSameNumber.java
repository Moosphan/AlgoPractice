package algo.questions.search;

/**
 * @author Moosphon
 * @date 2020/5/4 下午7:12
 * @desc 在数组中查找一个可能出现多次的数字
 * Thought: 二分法查找
 * Questions:
 *      1. 查找第一个值等于给定值的元素
 *      2. 查找最后一个值等于给定值的元素
 */
public class SearchWithSameNumber {

    //查找第一个值等于给定值的元素
    int findFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid-1] != value) return mid;
                // mid 一定在[low, mid-1]之间
                else high = mid - 1;
            }
        }
        return -1;
    }

    // 查找最后一个值等于给定值的元素
    int findLast(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n-1 || a[mid+1] != value) return mid;
                    // mid 一定在[mid+1, high]之间
                else low = mid + 1;
            }
        }
        return -1;
    }
}
