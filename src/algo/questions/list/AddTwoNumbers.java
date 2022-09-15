package algo.questions.list;

/**
 * 两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 *
 * @since 2022/09/14
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 记录进位值
        int carry = 0;
        // 新建头指针用于返回结果
        ListNode head = new ListNode(0);
        // 标记当前计算的节点位置指针
        ListNode curNode = head;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
        }
        // 如果l1存在剩余节点，需要继续计算
        while (l1 != null) {
            int partSum = (l1.val + carry) % 10;
            curNode.next = new ListNode(partSum);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            curNode = curNode.next;
        }
        // 如果l2存在剩余节点，同样需要继续计算
        while (l2 != null) {
            int partSum = (l2.val + carry) % 10;
            curNode.next = new ListNode(partSum);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            curNode = curNode.next;
        }
        // 如果 l1 和 l2 一样长，但是最后需要额外增加一位来保存进位 e.g, 254+756=1010
        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }
        // head和curNode操作的实际上是同一个地址的变量，每次循环这个变量都发生了改变；
        // 而head始终指向的是头部节点而已，然而curNode却随着遍历指向尾部了。
        return head.next;
    }

    public static class ListNode {
         int val;
         public ListNode next;
         public ListNode() {}
         public ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
             StringBuilder message = new StringBuilder(val+"");
             ListNode p = this.next;
             while (p != null) {
                 message.append("->").append(p.val);
                 p = p.next;
             }
            return message.toString();
        }
    }
}
