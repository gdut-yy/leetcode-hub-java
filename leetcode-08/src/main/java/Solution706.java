import java.util.HashMap;
import java.util.Map;

public class Solution706 {
    static class MyHashMap {
        private final Map<Integer, Integer> hashMap;

        public MyHashMap() {
            hashMap = new HashMap<>();
        }

        public void put(int key, int value) {
            hashMap.put(key, value);
        }

        public int get(int key) {
            return hashMap.getOrDefault(key, -1);
        }

        public void remove(int key) {
            hashMap.remove(key);
        }
    }
}
/*
706. 设计哈希映射
https://leetcode-cn.com/problems/design-hashmap/

不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 */