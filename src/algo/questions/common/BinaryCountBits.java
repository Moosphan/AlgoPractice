package algo.questions.common;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * e.g, Input: 2, output: [0,1,1]
 * T(n) = O(n*k) (k为二进制位数,像Java中整型32位，则为常量)
 * @link <a href="https://leetcode.cn/problems/counting-bits/">Count bits</a>
 * @since 2022/09/16
 */
public class BinaryCountBits {
    public int[] countBits(int n) {
        int[] answers = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                j = j&(j-1);
                answers[i]++;
            }
            System.out.println("index: " + i + ", value: " + answers[i]);
        }
        return answers;
    }

    /**
     * 同样可以实现，利用i&(i-1)中1的个数比i少1个，那么可以利用answers[i & (i - 1)] + 1来求解。
     * 另外，answers[i & (i - 1)]肯定在数组中是存在的，且小于i。
     * T(n) = O(n)
     * @param n
     * @return
     */
    public int[] countBitsBrief(int n) {
        int[] answers = new int[n+1];
        for (int i = 1; i <= n; i++) {
            answers[i] = answers[i & (i - 1)] + 1;
        }
        return answers;
    }

    /**
     * 利用位运算(二进制中偶数i和i/2的1的个数相同，奇数i比i/2中1的个数多一个)
     * T(n) = O(n)
     * @param n
     * @return
     */
    public int[] countBitsByBitOperation(int n) {
        int[] answers = new int[n+1];
        for (int i = 1; i <= n; i++) {
            answers[i] = answers[i >> 1] + (i & 1);
        }
        return answers;
    }
}
