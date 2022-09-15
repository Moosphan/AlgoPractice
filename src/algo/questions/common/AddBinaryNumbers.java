package algo.questions.common;

/**
 * 两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。e.g,
 * a = "11", b = "1" => "100"
 * Note: 思想与{@link algo.questions.list.AddTwoNumbers}类似。
 * @link <a href="https://leetcode.cn/problems/add-binary/">add binary</a>
 * @since 2022/09/16
 */
public class AddBinaryNumbers {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        // 当前计算的位
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        // 进位值
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            // 得到每一位的二进制数字表示
            int aDigit = aIndex >= 0 ? (a.charAt(aIndex--) - '0') : 0;
            int bDigit = bIndex >= 0 ? (b.charAt(bIndex--) - '0') : 0;
            // 计算每一位的和
            int sum = aDigit + bDigit + carry;
            // 计算进位
            carry = sum >= 2 ? 1 : 0;
            // 根据进位情况计算每一位和的最终表示
            result.append(sum >= 2 ? sum - 2 : sum);
        }
        // 处理最后一位仍存在进位的情况
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
