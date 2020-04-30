package string;

import common.Node;

/**
 * @author Moosphon
 * @date 2020/4/1 下午10:42
 * @desc 判断回文字符串的相关算法
 */
public class PalindromicString {

    class StringNode extends Node<String> {
        StringNode next;
        StringNode(String value) {
            super(value);
        }
    }

    /**
     * 基本法
     * T(n)-best = O(1) | T(n)-bad = O(n) | T(n)-average = O(n)
     * S(n) =
     * @param target target string
     * @return whether if Palindromic String
     */
    public boolean judgeIfPalindromicString(String target) {
        if (target == null || target.length() == 1) {
            return true;
        }
        int low = 0;
        int high = target.length() - 1;
        while (low < high) {
            if (target.charAt(low) != target.charAt(high)) {
                return false;
            }
            low ++;
            high --;
        }
        return true;
    }

    /**
     * 单链表法
     * @param  head 存储String单链表
     * @return whether if Palindromic String
     */
    public boolean judgeIfPalindromicString(StringNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        StringNode slow = head;
        StringNode fast = head;

        //...
        return  false;
    }


}
