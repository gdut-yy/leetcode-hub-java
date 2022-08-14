import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution484Tests {
    private final Solution484 solution484 = new Solution484();

    @Test
    public void example1() {
        String s = "I";
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution484.findPermutation(s));
    }

    @Test
    public void example2() {
        String s = "DI";
        int[] expected = {2, 1, 3};
        Assertions.assertArrayEquals(expected, solution484.findPermutation(s));
    }
}
