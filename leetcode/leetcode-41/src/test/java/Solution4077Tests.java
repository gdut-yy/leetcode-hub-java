import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4077Tests {
    private final Solution4077 solution4077 = new Solution4077();

    @Test
    public void example1() {
        String[] words = {"bad", "bag", "fig", "fed"};
        int[] target = {3, 1, 0, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution4077.minInversions(words, target));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "ac", "ba", "bc"};
        int[] target = {0, 3, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution4077.minInversions(words, target));
    }
}
