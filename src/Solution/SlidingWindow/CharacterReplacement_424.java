package Solution.SlidingWindow;

/**
 * Given a string that consists of only uppercase English letters.
 * Replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters after performing the above operations.
 *
 * @author BorisMirage
 * Time: 2019/06/18 17:18
 * Created with IntelliJ IDEA
 */

public class CharacterReplacement_424 {
    /**
     * Sliding window.
     * The window will shift right, or extend its size only by appending one char on the right.
     * The window can only extend its size when the count of the new char exceeds the historical max count.
     * Therefore, count each char's appearance during the traverse.
     * we only care if the max count exceeds the historical max count
     *
     * @param s given string
     * @param k limit of replacing operations
     * @return longest substring containing all repeating letters
     */
    public int characterReplacement(String s, int k) {

        /* Corner case */
        if (s.length() < 1) {
            return 0;
        }
        if (k > s.length()) {
            return s.length();
        }

        int[] store = new int[26];      // store char appearance

        int max = 0, window = 0, from = 0;

        for (int i = 0; i < s.length(); i++) {

            max = Math.max(max, ++store[s.charAt(i) - 'A']);        // find window that contains the largest number of reoccurring char

            while (i - from + 1 > k + max) {        // set substring length (i - from + 1) to be equal to max length (k + max)
                store[s.charAt(from++) - 'A']--;        // find chars require operation
            }
            window = Math.max(window, i - from + 1);        // find max window size
        }

        return window;
    }

    public static void main(String[] args) {
        CharacterReplacement_424 test = new CharacterReplacement_424();
//        System.out.println(test.characterReplacement("AABABBA", 2));
        System.out.println(test.characterReplacement("AABABBA", 1));

    }
}
