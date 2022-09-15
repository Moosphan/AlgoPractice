package algo.questions.common;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * e.g, Input: 2, output: [0,1,1]
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
        }
        return answers;
    }
}
