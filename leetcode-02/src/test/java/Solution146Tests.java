import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution146Tests {
    @Test
    public void example1() {
        Solution146.LRUCache lruCache = new Solution146.LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assertions.assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        Assertions.assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        Assertions.assertEquals(-1, lruCache.get(1));
        Assertions.assertEquals(3, lruCache.get(3));
        Assertions.assertEquals(4, lruCache.get(4));
    }
}
