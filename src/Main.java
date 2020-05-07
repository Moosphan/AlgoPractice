import questions.sort.ArrayMaxNumber;

/**
 * Launcher programme.
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

