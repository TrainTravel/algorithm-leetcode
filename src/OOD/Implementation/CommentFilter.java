package OOD.Implementation;

import OOD.Interface.Filter;

import java.util.HashSet;

/**
 * Amazon comment filter system mechanism.
 *
 * @author BorisMirage
 * Time: 2019/08/19 11:01
 * Created with IntelliJ IDEA
 */

class CommentFilter implements Filter {

    private static HashSet<String> abusiveWords = new HashSet<String>() {{
        add("shit");
        add("ass hole");
        add("asshole");
        add("idiot");
    }};

    public static boolean isValid(String s) {

        String[] tmp = s.split(" ");

        for (String s1 : tmp) {
            if (abusiveWords.contains(s1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean addNewWords(String s) {
        return abusiveWords.add(s);
    }

    public static boolean removeWords(String s) {
        return abusiveWords.remove(s);
    }
}

class Comment {
    private String comment;

    Comment(String s) {
        comment = s;
    }

    boolean isValid() {
        return CommentFilter.isValid(comment);
    }
}