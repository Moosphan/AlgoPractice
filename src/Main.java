import questions.sort.ArrayMaxNumber;

/**
 * Launcher programme.
 * TODO-LIST:
 * 1. 散列表的实现和锻炼
 * 2. 图的实现和应用实战
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 8, 7, 6, 2};

        findKMax(array, 3);
    }

    // 寻找数组中第k大的数字
    static private void findKMax(int[] a, int k) {
        ArrayMaxNumber selectionSort = new ArrayMaxNumber();
        System.out.println(selectionSort.findKMax(a, k));
    }
}

