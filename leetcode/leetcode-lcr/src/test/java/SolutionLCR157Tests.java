import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionLCR157Tests {
    private final SolutionLCR157 solutionLCR157 = new SolutionLCR157();

    @Test
    public void example1() {
        String s = "abc";
        String[] expected = {"abc", "acb", "bac", "bca", "cab", "cba"};
        String[] actual = solutionLCR157.goodsOrder(s);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "aab";
        String[] expected = {"aba", "aab", "baa"};
        String[] actual = solutionLCR157.goodsOrder(s);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
