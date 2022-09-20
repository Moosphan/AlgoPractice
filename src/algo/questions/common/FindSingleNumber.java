package algo.questions.common;

/**
 * 1.给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现 2 次。找出那个只出现了一次的元素。
 * e.g. [4,1,2,1,2] -> 4
 * 2.给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现 3 次。找出那个只出现了一次的元素。
 * e.g. [3,6,3,1,6,8,3,1,6,1] -> 8
 * Note: 要求是原地算法，空间复杂度O(1)
 * @since 2022/09/20
 */
public class FindSingleNumber {
    // 利用任何一个数异或自身都是0
    public int singleNumberInTwice(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    // 利用如果32位数组任意数第i位之和能够被3整除，说明该数i位是0；如果能被3除余1，则说明是1
    public int singleNumberInThrice(int[] nums) {
        int[] sumBits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 0; j < 32; j++) {
                // 首先求数组中所有number的第i位之和
                sumBits[j] += (cur >> (31 - j)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + sumBits[i] % 3;
        }
        return result;
    }
}
