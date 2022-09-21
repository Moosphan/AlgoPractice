package algo.questions.common;

/**
 * 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。
 * 如果不存在这样的两个单词，返回 0 。
 *
 * @link <a href="https://leetcode.cn/problems/maximum-product-of-word-lengths">MaxProduct</a>
 * @since 2022/09/21
 */
public class TwoWordsMaxProduct {
    /**
     * Thought: 如果两个单词的字母二进制映射值做与运算得到 0，则说明两个单词无重复的字母。
     */
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char character: words[i].toCharArray()) {
                // 将单词的各位用1表示
                flags[i] |= 1 << (character - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int curProduct = words[i].length() * words[j].length();
                    max = Math.max(max, curProduct);
                }
            }
        }
        return max;
    }
}
