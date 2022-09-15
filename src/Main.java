import algo.questions.backtrack.SubSetsProvider;
import algo.questions.common.AddBinaryNumbers;
import algo.questions.common.DivisionOfTwoNumbers;
import algo.questions.list.AddTwoNumbers;
import questions.sort.ArrayMaxNumber;

import java.util.List;

/**
 * Launcher programme.
 * TODO-LIST:
 * 1. 散列表的实现和锻炼
 * 2. 图的实现和应用实战
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 8, 7, 6, 2};

        //findKMax(array, 3);
        //getAllSubSets();
        //addTwoNumbers();
        //twoNumbersDivision();
        addTwoBinary();
    }

    private static void addTwoBinary() {
        String result = new AddBinaryNumbers().addBinary("001", "010");
        System.out.println("Binary sum result: " + result);
    }

    private static void twoNumbersDivision() {
        int result = new DivisionOfTwoNumbers().divide(150, -2);
        System.out.println("Division result: " + result);
    }

    private static void addTwoNumbers() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(9);
        l1.next = new AddTwoNumbers.ListNode(9);
        l1.next.next = new AddTwoNumbers.ListNode(9);
        l1.next.next.next = new AddTwoNumbers.ListNode(9);
        l1.next.next.next.next = new AddTwoNumbers.ListNode(9);
        l1.next.next.next.next.next = new AddTwoNumbers.ListNode(9);
        l1.next.next.next.next.next.next = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(9);
        l2.next = new AddTwoNumbers.ListNode(9);
        l2.next.next = new AddTwoNumbers.ListNode(9);
        l2.next.next.next = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    private static void getAllSubSets() {
        int[] array = {1,2,3};
        List<List<Integer>> result = new SubSetsProvider().allSubSets(array);
        System.out.println("All sub sets: " + result);
    }

    // 寻找数组中第k大的数字
    static private void findKMax(int[] a, int k) {
        ArrayMaxNumber selectionSort = new ArrayMaxNumber();
        System.out.println(selectionSort.findKMax(a, k));
    }
}

