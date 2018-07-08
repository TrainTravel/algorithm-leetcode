package Olivia;

public class IsAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] result = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            result[t.charAt(i) - 'a']--;
            if (result[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
