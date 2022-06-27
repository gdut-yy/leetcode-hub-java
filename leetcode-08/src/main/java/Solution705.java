import java.util.HashSet;
import java.util.Set;

public class Solution705 {
    static class MyHashSet {
        private final Set<Integer> hashset;

        public MyHashSet() {
            hashset = new HashSet<>();
        }

        public void add(int key) {
            hashset.add(key);
        }

        public void remove(int key) {
            hashset.remove(key);
        }

        public boolean contains(int key) {
            return hashset.contains(key);
        }
    }
}
/*
705. 设计哈希集合
https://leetcode.cn/problems/design-hashset/

不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

可以参考 Java 源码实现，在 Java 中，HashSet 是由 HashMap 实现的。
 */