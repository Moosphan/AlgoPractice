package common.sort.counting;

/**
 * @author Moosphon
 * @date 2020/5/3 上午10:55
 * @desc 计数排序（特殊的桶排序）
 * 原理：计数排序其实是桶排序的一种特殊情况。
 *      当要排序的 n 个数据，所处的范围并不大的时候，比如最大值是 k，我们就可以把数据划分成 k 个桶。
 *      每个桶内的数据值都是相同的，省掉了桶内排序的时间。
 * 特点：计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 *      而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 *
 * 时间复杂度：0(n)
 */
public class CountingSort {

    public int[] countingSort(int[] array, int n) {
        if (n < 1) return null;
        // 找出数据范围
        int max = array[0];
        for (int i = 0; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        // 创建容器并初始化
        int[] container = new int[max+1];
        for (int i = 0; i <= max; i++) {
            container[i] = 0;
        }
        // 存储每个数据的出现次数
        for (int i = 0; i < n; i++) {
            container[array[i]]++;
        }
        // 依次累加求和
        for (int i = 0; i <= max; i++) {
            container[i] = container[i] + container[i-1];
        }

        // 创建临时数组存储排序后的结果
        int[] results = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int index = container[array[i]] - 1;
            results[index] = array[i];
            container[array[i]] = index;
        }

        return results;
    }
}
