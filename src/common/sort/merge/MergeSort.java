package common.sort.merge;

/**
 * @author Moosphon
 * @date 2020/4/30 下午2:21
 * @desc 归并排序
 * 原理：如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
 *      再将排好序的两部分合并在一起，这样整个数组就都有序了。
 * 特点：基于分治思想和递归，是稳定的排序算法，非原地排序算法。
 *      递推公式：merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 *      终止条件：p >= r
 *
 * 时间复杂度：最好、最坏和平均都是O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {

    public int[] sort(int[] array, int n) {
        if (n < 1) return  null;
        mergeSort(array, 0, n-1);
        return array;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        // 分治递归分解
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        // 合并序列
        merge(array, start, mid, end);
    }

    // 合并
    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int k = 0;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) { // 等于号保证算法稳定性(保证相同值排序前后的顺序不改变)
                temp[k++] = array[left++];
            } else  {
                temp[k++] = array[right++];
            }
        }
        // 找到有剩余元素的区间
        int restStartIndex = left;
        int restEndIndex = mid;
        if (right <= end) {
            restStartIndex = right;
            restEndIndex = end;
        }
        // 将剩下的元素拷贝到临时数组
        while (restStartIndex <= restEndIndex) {
            temp[k++] = array[restStartIndex++];
        }
        for (int i = 0; i < end - start + 1; i++) {
            array[start+i] = temp[i];
        }

    }
}
