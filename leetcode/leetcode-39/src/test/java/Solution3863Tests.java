import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3863Tests {
    private final Solution3863 solution3863 = new Solution3863();

    @Test
    public void example1() {
        String s = "dog";
        int expected = 1;
        Assertions.assertEquals(expected, solution3863.minOperations(s));
    }

    @Test
    public void example2() {
        String s = "card";
        int expected = 2;
        Assertions.assertEquals(expected, solution3863.minOperations(s));
    }

    @Test
    public void example3() {
        String s = "gf";
        int expected = -1;
        Assertions.assertEquals(expected, solution3863.minOperations(s));
    }
}