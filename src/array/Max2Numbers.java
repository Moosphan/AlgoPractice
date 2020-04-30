package array;

/**
 * Get two biggest numbers in a array with integer type.
 * @date 2020/03/22 00:15
 */
public class Max2Numbers {

    /**
     * First thought with original way: three layer.
     * 从数组区间a[low, high)找出最大的两个数a[x1]，a[x2]. (a[x1] >= a[x2])
     * @return two numbers
     * T(n) = O(n-1+max1-low-1+high-max1-1) = O(n+high-low-3) = O(2n - 3)
     */
    public int[] getTwoMaxNumbers(int[] array, int low, int high) {
        int[] result = new int[2];
        // 定义最大两个数的位于数组中的下标
        int max1 = low, max2 = low;
        // 先找到最大值
        for (int i = low + 1; i < high; i++) {          // O(n-1)
            // find the max number
            if (array[max1] < array[i]) max1 = i;
        }
        // 找到除最大值之前的数中的最大值
        for (int j = low + 1; j < max1; j++) {          // O(max1 - low - 1)
            if (array[max2] < array[j]) max2 = j;
        }
        // 找到除最大值之后的数中的最大值
        for (int k = max1 + 1; k < high; k++) {         // O(high - max - 1)
            if (array[max2] < array[k]) max2 = k;
        }
        // 最终得到最大值和次大值
        result[0] = max1;
        result[1] = max2;
        return result;
    }


    
}
