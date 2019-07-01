package Solution.BitOpearation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * @author BorisMirage
 * Time: 2019/07/01 11:04
 * Created with IntelliJ IDEA
 */

public class FindRepeatedDnaSequences_187 {
    /**
     * Encoding each 'A', 'C', 'G', 'T' into binary digit, such as 00, 01, 10, 11.
     * In this way, each 10-letter-long sequences will be 20 bits long, which is under size of an int.
     * Map each subsequence into bits and check if each sequence has been shown before.
     *
     * @param s given DNA molecule
     * @return all the 10-letter-long sequences in s
     */
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> out = new ArrayList<>();
        HashSet<Integer> sequence = new HashSet<>();                // save previous sequence
        HashSet<Integer> duplicatedSequence = new HashSet<>();      // save previous result added into list
        char[] map = new char[26];

        map['C' - 'A'] = 1;     // mapping 'C' to 01, 'A' is 00
        map['G' - 'A'] = 2;     // mapping 'G' to 10
        map['T' - 'A'] = 3;     // mapping 'T' to 11

        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;

            for (int j = i; j < i + 10; j++) {      // search 10 chars ahead
                v <<= 2;                            // left shift 2 digit for new incoming char
                v |= map[s.charAt(j) - 'A'];        // add coding to the end to extend
            }

            /*
             * 1. This sequence is not a new sequence (duplicated)
             * 2. This duplicated sequence has not been added to result (avoid duplicated result in output list) */
            if (!sequence.add(v) && duplicatedSequence.add(v)) {
                out.add(s.substring(i, i + 10));
            }
        }
        return out;
    }
}
