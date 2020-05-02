import common.sort.quick.QuickSort;
import questions.sort.ArrayMaxNumber;

/**
 * Launcher programme.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 8, 7, 6, 2};

        ArrayMaxNumber selectionSort = new ArrayMaxNumber();
        System.out.println(selectionSort.findKMax(array, 3));
//        int[] result = selectionSort.sort(array, array.length);
//        for (int aResult : result) {
//            System.out.println(aResult);
//        }

    }
}
