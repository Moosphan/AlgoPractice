package questions.sort;

/**
 * @author Moosphon
 * @date 2020/5/2 下午6:36
 * Q: O(n) 时间复杂度内求无序数组中的第 K 大元素。
 * A: 我们可以利用分区的思想，选择数组区间 A[0…n-1]的最后一个元素 A[n-1]作为 pivot，对数组 A[0…n-1]原地分区，这样数组就分成了三部分，
 *    A[0…p-1]、A[p]、A[p+1…n-1]。如果 p+1=K，那 A[p]就是要求解的元素；
 *    如果 K>p+1, 说明第 K 大元素出现在 A[p+1…n-1]区间，
 *    我们再按照上面的思路递归地在 A[p+1…n-1]这个区间内查找。
 *    同理，如果 K<p+1，那我们就在 A[0…p-1]区间查找。
 */
public class ArrayMaxNumber {

    public int findKMax(int[] array, int k) {
        int kValue;
        if (array == null || array.length < 1) return -1;
        int index = quickSort(array, 0, array.length-1, k);
        kValue = array[index];
        return kValue;
    }

    private int quickSort(int[] array, int start, int end, int k) {
        //int index = quickSort(algo.array, 0, algo.array.length - 1, k);
        int index;
        int pivotPosition = partition(array, start, end);
        if (pivotPosition + 1 == k) {
            // 找到目标值
           index = pivotPosition;
        } else {
            if (pivotPosition + 1 < k) {
                // 说明基准值下标还没达到，需要在后面区间找
                index = quickSort(array, pivotPosition+1, end, k);
            } else {
                // 说明基准值下标超过了k的下标，需要在前面区间找
                index = quickSort(array, start, pivotPosition-1, k);
            }
        }
        return index;
    }

    // 返回pivot基准值的下标(将较大值排在前面)
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (array[i] > pivot) {
                // 碰到较大值则交换
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
