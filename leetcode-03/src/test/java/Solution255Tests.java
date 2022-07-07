import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution255Tests {
    private final Solution255 solution255 = new Solution255();

    @Test
    public void example1() {
        int[] preorder = {5, 2, 1, 3, 6};
        Assertions.assertTrue(solution255.verifyPreorder(preorder));
    }

    @Test
    public void example2() {
        int[] preorder = {5, 2, 6, 1, 3};
        Assertions.assertFalse(solution255.verifyPreorder(preorder));
    }
}
