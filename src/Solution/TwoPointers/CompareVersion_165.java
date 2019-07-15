package Solution.TwoPointers;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1; otherwise return 0.
 * The version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three".
 * It is the fifth second-level revision of the second first-level revision.
 * Default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
 * Its third and fourth level revision number are both 0.
 *
 * @author BorisMirage
 * Time: 2019/07/14 21:19
 * Created with IntelliJ IDEA
 */

public class CompareVersion_165 {
    /**
     * Two pointers. Note that leading 0 in version # should not be considered.
     *
     * @param version1 first version #
     * @param version2 second version #
     * @return version1 > version2 return 1; version1 < version2 return -1; otherwise return 0.
     */
    public int compareVersion(String version1, String version2) {

        String[] l1 = version1.split("\\."), l2 = version2.split("\\.");

        for (int i = 0; i < Math.max(l1.length, l2.length); i++) {
            int v1 = i < l1.length ? Integer.valueOf(l1[i]) : 0;        // avoid point moving out of list
            int v2 = i < l2.length ? Integer.valueOf(l2[i]) : 0;        // avoid point moving out of list

            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion_165().compareVersion("0.1", "1.1"));      // -1
        System.out.println(new CompareVersion_165().compareVersion("1.0.1", "1"));      // 1
        System.out.println(new CompareVersion_165().compareVersion("7.5.2.4", "7.5.3"));      // -1
        System.out.println(new CompareVersion_165().compareVersion("1.01", "1.001"));      // 0
        System.out.println(new CompareVersion_165().compareVersion("1.0", "1.0.0"));      // 0
    }
}
