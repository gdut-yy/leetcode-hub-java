import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution432Tests {
    @Test
    public void example1() {
        Solution432.AllOne allOne = new Solution432.AllOne();
        allOne.inc("hello");
        allOne.inc("hello");

        // 返回 "hello"
        Assertions.assertEquals("hello", allOne.getMaxKey());

        // 返回 "hello"
        Assertions.assertEquals("hello", allOne.getMinKey());
        allOne.inc("leet");

        // 返回 "hello"
        Assertions.assertEquals("hello", allOne.getMaxKey());

        // 返回 "leet"
        Assertions.assertEquals("leet", allOne.getMinKey());
    }
}
