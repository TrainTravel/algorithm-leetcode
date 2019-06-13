package Playground;

import java.util.TreeMap;

/**
 * @author BorisMirage
 * Time: 2019/06/13 14:17
 * Created with IntelliJ IDEA
 */

public class OrderedMap {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        System.out.println(map);
    }
}
