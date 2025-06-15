import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3577Tests {
    private final Solution3577 solution3577 = new Solution3577();

    @Test
    public void example1() {
        int[] complexity = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3577.countPermutations(complexity));
    }

    @Test
    public void example2() {
        int[] complexity = {3, 3, 3, 4, 4, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3577.countPermutations(complexity));
    }
}