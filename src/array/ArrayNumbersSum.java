package array;

/**
 * @author Moosphon
 * @date 2020/3/25 下午1:42
 * @desc 数组中前n个数字的求和
 */
public class ArrayNumbersSum {

    /**
     * Way1: 线性递归 (基本)
     * T(n) = O(1) * (n+1) = O(n)[递归跟踪]
     * T(n) = O(n - 1) + O(1), T(0) = O(1) => O(n) [递推关系方程]
     * @param array target array
     * @param n     target index
     * @return      sum before index of n+1
     */
    public int sum(int[] array, int n) {
        return n < 1 ? 0 : sum(array, n - 1);
    }

    /**
     * Way2: 二分递归法
     * @param array target array
     * @param low   start index
     * @param high  end index
     * @return      sum between low to high
     */
    public int sum(int[] array, int low, int high) {
        if (low == high) return low;
        int middle = (low + high) / 2;
        return sum(array, low, middle) + sum(array, middle + 1, high);
    }

}
