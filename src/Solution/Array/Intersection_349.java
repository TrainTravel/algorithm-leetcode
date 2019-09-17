package Solution.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two arrays, find their unique common element.
 *
 * @author BorisMirage
 * Time: 2019/02/22 20:34
 * Created with IntelliJ IDEA
 */

public class Intersection_349 {
    /**
     * One set store first array element without duplication, use one linked list to store common element.
     *
     * @param nums1 first int array
     * @param nums2 second int array
     * @return unique common int
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        for (int n1 : nums1) {
            s1.add(n1);
        }
        for (int n2 : nums2) {
            if (s1.contains(n2)) {
                l2.add(n2);
                s1.remove(n2);
            }
        }

        int[] out = new int[l2.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = l2.pop();
        }
        return out;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {2, 2, 0, 0, 11, 5};
        Intersection_349 t = new Intersection_349();
        System.out.println(Arrays.toString(t.intersection(a, b)));
    }
}
