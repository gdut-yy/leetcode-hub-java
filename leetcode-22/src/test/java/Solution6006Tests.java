import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6006Tests {
    private final Solution6006 solution6006 = new Solution6006();

    @Test
    public void example1() {
        int[] beans = {4, 1, 6, 5};
        long expected = 4;
        Assertions.assertEquals(expected, solution6006.minimumRemoval(beans));
    }

    @Test
    public void example2() {
        int[] beans = {2, 10, 3, 2};
        long expected = 7;
        Assertions.assertEquals(expected, solution6006.minimumRemoval(beans));
    }
}
