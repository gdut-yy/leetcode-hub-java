import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3545Tests {
    private final Solution3545 solution3545 = new Solution3545();

    @Test
    public void example1() {
        String s = "abc";
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3545.minDeletion(s, k));
    }

    @Test
    public void example2() {
        String s = "aabb";
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3545.minDeletion(s, k));
    }

    @Test
    public void example3() {
        String s = "yyyzz";
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3545.minDeletion(s, k));
    }
}