import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3494Tests {
    private final Solution3494 solution3494 = new Solution3494();

    @Test
    public void example1() {
        int[] skill = {1, 5, 2, 4};
        int[] mana = {5, 1, 4, 2};
        long expected = 110;
        Assertions.assertEquals(expected, solution3494.minTime(skill, mana));
    }

    @Test
    public void example2() {
        int[] skill = {1, 1, 1};
        int[] mana = {1, 1, 1};
        long expected = 5;
        Assertions.assertEquals(expected, solution3494.minTime(skill, mana));
    }

    @Test
    public void example3() {
        int[] skill = {1, 2, 3, 4};
        int[] mana = {1, 2};
        long expected = 21;
        Assertions.assertEquals(expected, solution3494.minTime(skill, mana));
    }
}