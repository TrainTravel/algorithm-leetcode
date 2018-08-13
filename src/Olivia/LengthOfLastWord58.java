package Olivia;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] tmp = s.split(" ");
        // remember the special case
        if (tmp.length == 0)
            return 0;
        return tmp[tmp.length - 1].length();
    }
}
