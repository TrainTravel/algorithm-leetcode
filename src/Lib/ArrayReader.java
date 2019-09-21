package Lib;

import java.util.HashMap;

/**
 * @author BorisMirage
 * Time: 2019/09/21 11:17
 * Created with IntelliJ IDEA
 */

public class ArrayReader {
    private HashMap<Integer, Integer> m = new HashMap<>();

    void setArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], i);
        }
    }

    public int get(int k) {
        return m.getOrDefault(k, 2147483647);
    }
}
