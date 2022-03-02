package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryIndexedTreeTests {
    @Test
    public void testQuery() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        BinaryIndexedTree bit = new BinaryIndexedTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            bit.update(i + 1, nums[i]);
        }
        // 1
        Assertions.assertEquals(1, bit.query(0, 2));
        // -1
        Assertions.assertEquals(-1, bit.query(2, 5));
        // -3
        Assertions.assertEquals(-3, bit.query(0, 5));
    }
}
