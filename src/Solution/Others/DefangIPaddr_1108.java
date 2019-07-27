package Solution.Others;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * @author BorisMirage
 * Time: 2019/07/27 14:34
 * Created with IntelliJ IDEA
 */

public class DefangIPaddr_1108 {
    /**
     * String builder.
     *
     * @param address given address string
     * @return defanged version of that IP address
     */
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[").append(".").append("]");
            } else {
                sb.append(address.charAt(i));
            }
        }

        return sb.toString();
    }
}
