package Olivia;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String cur : strs) {
            char[] key = cur.toCharArray();
            Arrays.sort(key);
            String keyStr = String.valueOf(key);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(cur);
        }

        return new ArrayList<>(map.values());


    }
}
