package Solution.FindKth;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * Note:
 * 1. k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author BorisMirage
 * Time: 2019/06/24 16:05
 * Created with IntelliJ IDEA
 */

public class TopKFrequent_347 {
    /**
     * Bucket sorting.
     * The bucket is the frequency of each element.
     * After adding all elements with their frequency into hash map, iterate the map and add all frequency to list.
     * Iterate the bucket list, find k elements that are most frequent.
     *
     * @param nums given array
     * @param k    k most frequent elements
     * @return k most frequent elements
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];     // index is the frequency, value is elements with this frequency
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int key : hm.keySet()) {
            int frequency = hm.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }
        return res;
    }

    /**
     * Direct approach by two hash map. One hash map save each element in array with its frequency.
     * The other hash map store the frequency and its elements.
     *
     * @param nums given array
     * @param k    k most frequent elements
     * @return k most frequent elements
     */
    public List<Integer> twoHashMap(int[] nums, int k) {
        List<Integer> out = new LinkedList<>();

        HashMap<Integer, Integer> m = new HashMap<>();     // save the key - frequency pair

        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) - 1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(m.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));       // sort map based on value instead of key

        for (int i = 0; i < k; i++) {
            out.add(list.get(i).getKey());
        }

        return out;
    }

    public static void main(String[] args) {
        TopKFrequent_347 test = new TopKFrequent_347();
        System.out.println(test.twoHashMap(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
