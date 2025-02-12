import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3443Tests {
    private final Solution3443 solution3443 = new Solution3443();

    @Test
    public void example1() {
        String s = "NWSE";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3443.maxDistance(s, k));
    }

    @Test
    public void example2() {
        String s = "NSWWEW";
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution3443.maxDistance(s, k));
    }
}