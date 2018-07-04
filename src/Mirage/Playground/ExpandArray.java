package Mirage.Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 2/26/18
 * Time: 15:16
 */


public class ExpandArray {

    private int[] expandArray;
    private HashMap<Integer, List<Integer>> arrayMap = new HashMap<>();

    /**
     * This class is based on array object, which contains some basic method of an array.
     * And it has some expanded function, such as quick sort, append a new element.
     *
     * @param array input array
     */
    public ExpandArray(int[] array) {
        expandArray = array;
        arrayMap();
    }

    /**
     * Store array index and value into map
     * key - array item
     * value - position (in ArrayList)
     */
    private void arrayMap() {
        for (int i = 0; i < expandArray.length; i++) {
            List<Integer> cur = arrayMap.getOrDefault(i, new ArrayList<>());
            cur.add(i);
            arrayMap.put(expandArray[i], cur);
        }
    }

    /**
     * Check whether value is in array.
     *
     * @param value target value
     * @return true if in array
     */
    private boolean isExist(int value) {
        return arrayMap.containsKey(value);
    }

    /**
     * Obtain position based on given value.
     *
     * @param value given value
     * @return position list
     */
    private List<Integer> getPosition(int value) {
        return arrayMap.get(value);
    }

    /**
     * Obtain value based on index
     * @param index given index
     * @return 
     */
    private int getValue(int index) {
        return expandArray[index];
    }

    private void addValueToLast(int value) {

    }

}
