package algo.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionHelper {

    public static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
