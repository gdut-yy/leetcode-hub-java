import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionO38Tests {
    private final SolutionO38 solutionO38 = new SolutionO38();

    @Test
    public void example1() {
        String s = "abc";
        String[] expected = {"abc", "acb", "bac", "bca", "cab", "cba"};
        String[] actual = solutionO38.permutation(s);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "aab";
        String[] expected = {"aba", "aab", "baa"};
        String[] actual = solutionO38.permutation(s);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
