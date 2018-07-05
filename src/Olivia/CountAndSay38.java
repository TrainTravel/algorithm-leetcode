package Olivia;

public class CountAndSay38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n; i++) {
            s = countHelper(s);
        }
        return s;

    }

    private String countHelper(String s) {
        StringBuilder s1 = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (cur == s.charAt(i)) {
                count++;
            } else {

                s1.append(count);
                s1.append(cur);
                cur = s.charAt(i);
                count = 1;
            }
        }

        s1.append(count);
        s1.append(cur);
        return s1.toString();
    }
}
