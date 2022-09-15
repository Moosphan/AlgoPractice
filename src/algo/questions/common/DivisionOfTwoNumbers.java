package algo.questions.common;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数dividend除以除数divisor得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * Note: 此题也来自于剑指offer。
 * 最小整数：-2^31 -> 0x80000000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divide-two-integers
 * @since 2022/09/15
 */
public class DivisionOfTwoNumbers {
    public int divide(int dividend, int divisor) {
        // 如果被除数是-2^31并且除数是-1，则会产生溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 统计两数中的负数
        int negativeSign = 2;
        // 将两个数都转为负数进行运算，防止溢出
        if (dividend > 0) {
            negativeSign--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negativeSign--;
            divisor = -divisor;
        }
        // 用减法运算实现除法运算
        int divisionResult = divisionOperation(dividend, divisor);
        return negativeSign == 1 ? -divisionResult : divisionResult;
    }

    private int divisionOperation(int dividend, int divisor) {
        int result = 0;
        int quotient = 1;
        int temp = divisor;
        while (dividend <= divisor) {
            // 负数的情况下，temp要比-2^30要大，否则会溢出
            if (dividend <= temp + temp && temp >= 0xc0000000) {
                temp += temp;
                quotient += quotient;
                System.out.println("Divisor sum: " + temp + ", quotient: " + quotient);
            } else {
                result += quotient;
                dividend -= temp;
                // reset values
                temp = divisor;
                quotient = 1;
                System.out.println("Dividend: " + dividend + ", result: " + result);
            }
        }
        return result;
    }
}
