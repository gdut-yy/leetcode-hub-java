import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4021Tests {
    private final Solution4021 solution4021 = new Solution4021();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 2;
        Assertions.assertEquals(expected, solution4021.minOperations(s));
    }

    @Test
    public void example2() {
        String s = "yb";
        int expected = 3;
        Assertions.assertEquals(expected, solution4021.minOperations(s));
    }
}