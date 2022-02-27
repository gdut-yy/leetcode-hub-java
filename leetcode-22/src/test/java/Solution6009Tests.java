import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6009Tests {
    private final Solution6009 solution6009 = new Solution6009();

    @Test
    public void example1() {
        String s = "leetcode";
        String t = "coats";
        int expected = 7;
        Assertions.assertEquals(expected, solution6009.minSteps(s, t));
    }

    @Test
    public void example2() {
        String s = "night";
        String t = "thing";
        int expected = 0;
        Assertions.assertEquals(expected, solution6009.minSteps(s, t));
    }
}
