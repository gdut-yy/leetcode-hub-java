import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3931Tests {
    private final Solution3931 solution3931 = new Solution3931();

    @Test
    public void example1() {
        String s = "132";
        Assertions.assertTrue(solution3931.isAdjacentDiffAtMostTwo(s));
    }

    @Test
    public void example2() {
        String s = "129";
        Assertions.assertFalse(solution3931.isAdjacentDiffAtMostTwo(s));
    }
}