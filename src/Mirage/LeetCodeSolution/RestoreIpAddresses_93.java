package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author BorisMirage
 * Time: 2019/01/20 16:49
 * Created with IntelliJ IDEA
 */

public class RestoreIpAddresses_93 {
    /**
     * Move "dot" in given string to divide ip into 4 segments and check validity.
     *
     * @param s given string
     * @return all valid ip
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        /* 3 loops as 3 "dot" in ip address */
        for (int i = 1; i < 4 && i < s.length() - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length(); k++) {

                    /* Make up ip by four segments */
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k);

                    /* Check Validity */
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    /**
     * Check given string is valid ip part or not.
     * 1. length > 0 && < 4
     * 2. value < 256
     *
     * @param s given string
     * @return if given string is valid ip part
     */
    private boolean isValid(String s) {
        return s.length() > 0 && s.length() < 4 && (s.charAt(0) != '0' || s.length() < 2) && Integer.parseInt(s) < 256;
    }
}
