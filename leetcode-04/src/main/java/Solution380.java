import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution380 {
    static class RandomizedSet {
        Map<Integer, Integer> hashMap;
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            hashMap = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }
            hashMap.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (hashMap.containsKey(val)) {
                int idx = hashMap.get(val);
                hashMap.put(list.get(list.size() - 1), idx);
                hashMap.remove(val);
                list.set(idx, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
/*
380. O(1) 时间插入、删除和获取随机元素
https://leetcode-cn.com/problems/insert-delete-getrandom-o1/

HashMap 插入和删除时间复杂度为 O(1).
获取随机元素需要用到数组。
HashMap + ArrayList 即可
 */