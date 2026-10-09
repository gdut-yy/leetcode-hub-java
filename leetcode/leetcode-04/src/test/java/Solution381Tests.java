import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution381Tests {
    @Test
    public void example1() {
        // 初始化一个空的集合。
        Solution381.RandomizedCollection collection = new Solution381.RandomizedCollection();

        // 返回 true，因为集合不包含 1。
        Assertions.assertTrue(collection.insert(1));
        // 将 1 插入到集合中。

        // 返回 false，因为集合包含 1。
        Assertions.assertFalse(collection.insert(1));
        // 将另一个 1 插入到集合中。集合现在包含 [1,1]。

        // 返回 true，因为集合不包含 2。
        Assertions.assertTrue(collection.insert(2));
        // 将 2 插入到集合中。集合现在包含 [1,1,2]。

        // getRandom 有 2/3 的概率返回 1，1/3 的概率返回 2。
        int random = collection.getRandom();
        Assertions.assertTrue(random == 1 || random == 2);

        // 返回 true，因为集合包含 1。
        Assertions.assertTrue(collection.remove(1));
        // 从集合中移除 1。集合现在包含 [1,2]。

        // getRandom 应该返回 1 或 2，两者的可能性相同。
        random = collection.getRandom();
        Assertions.assertTrue(random == 1 || random == 2);
    }
}
