import java.util.LinkedHashMap;

public class Solution146 {
    static class LRUCache {
        private final int capacity;
        private final LinkedHashMap<Integer, Integer> lruCache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.lruCache = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!lruCache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return lruCache.get(key);
        }

        public void put(int key, int value) {
            if (lruCache.containsKey(key)) {
                // 修改 key 的值
                lruCache.put(key, value);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }
            if (lruCache.size() >= this.capacity) {
                // 链表头部就是最久未使用的 key
                int oldestKey = lruCache.keySet().iterator().next();
                lruCache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            lruCache.put(key, value);
        }

        private void makeRecently(int key) {
            int val = lruCache.get(key);
            // 删除 key，重新插入到队尾
            lruCache.remove(key);
            lruCache.put(key, val);
        }
    }
}
/*
146. LRU 缓存机制
https://leetcode-cn.com/problems/lru-cache/

Google Guava 的 LocalCache 默认是一个 LRUCache, 它是基于队列实现的。
HashMap 插入和删除时间复杂度为 O(1). 但它无法找出最近最少使用的键，因此需要结合链表。
使用 jdk LinkedHashMap 进行模拟即可。
 */