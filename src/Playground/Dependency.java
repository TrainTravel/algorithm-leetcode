package Playground;

import java.util.*;

/**
 * Factual OA.
 *
 * @author BorisMirage
 * Time: 2019/08/01 10:36
 * Created with IntelliJ IDEA
 */

public class Dependency {
    public int dependency(String modulesToBuild, HashMap<String, LinkedList<String>> m) {
        HashSet<String> s = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(modulesToBuild);

        while (!q.isEmpty()) {
            String temp = q.poll();
            if (m.containsKey(temp)) {
                for (String str : m.get(temp)) {
                    if (s.add(str)) {
                        q.add(str);
                    }
                }
            }
        }

        System.out.println(s);
        return s.size();
    }

    public static void main(String[] args) {

        HashMap<String, LinkedList<String>> m = new HashMap<>();
        LinkedList<String> l = new LinkedList<>();
        l.add("b");
        l.add("c");

        m.put("a", new LinkedList<>(l));
        l.clear();
        l.add("d");
        l.add("e");
        l.add("f");
        m.put("c", new LinkedList<>(l));
        l.clear();
        l.add("g");
        l.add("d");
        m.put("b", new LinkedList<>(l));
        System.out.println(m);
        System.out.println(new Dependency().dependency("a", m));
    }
}
