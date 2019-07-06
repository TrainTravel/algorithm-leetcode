package Solution.Others;

import java.util.HashMap;

/**
 * @author BorisMirage
 * Time: 2019/07/06 12:11
 * Created with IntelliJ IDEA
 */

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!m.containsKey(num)) {
                int left = m.getOrDefault(num - 1, 0);
                int right = m.getOrDefault(num + 1, 0);
                m.put(num, left + right + 1);
                max = Integer.max(max, left + right + 1);

                m.put(num - left, left + right + 1);        // update left bound
                m.put(num + right, left + right + 1);       // update right bound
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive_128 test = new LongestConsecutive_128();
        System.out.println(test.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
