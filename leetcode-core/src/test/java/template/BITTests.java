package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BITTests {
    @Test
    public void test() {
        int[] nums = {1, 3, 5};
        BIT bit = new BIT(nums);
        // [0,2]
        Assertions.assertEquals(9, bit.getsum(0, 2));

        // update
        bit.add(1, 2 - bit.getsum(1, 1));

        // [0,2]
        Assertions.assertEquals(8, bit.getsum(0, 2));
    }
}
