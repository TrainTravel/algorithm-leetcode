package Helper;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/26/18
 * Time: 11:40
 */

public class MergeTwoSortedArray {

    public int[] MergeTwoSortedArray(int[] a1, int[] a2) {

        if (a1.length == 0) {
            return a2;
        }
        if (a2.length == 0) {
            return a1;
        }

        if (a1.length < a2.length) {
            int[] temp = a2;
            a2 = a1;
            a1 = temp;
        }

        int i1 = 0;
        int i2 = 0;
        int[] mergeArray = new int[a1.length + a2.length];

        for (int i = 0; i < mergeArray.length; i++) {
            if (i2 == a1.length) {
                mergeArray[i] = a2[i2];
                i2 += 1;
            } else if (i2 == a2.length) {
                mergeArray[i] = a1[i2];
                i2 += 1;
            } else {
                mergeArray[i] = Math.min(a1[i2], a2[i2]);
                if (mergeArray[i] == a1[i2]) {
                    i2 += 1;
                } else {
                    i2 += 1;
                }
            }
        }
        return mergeArray;
    }
}
