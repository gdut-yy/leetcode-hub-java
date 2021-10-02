import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionI0807Tests {
    private final SolutionI0807 solutionI0807 = new SolutionI0807();

    @Test
    public void example1() {
        String S = "qwe";
        String[] expected = {"qwe", "qew", "wqe", "weq", "ewq", "eqw"};
        String[] actual = solutionI0807.permutation(S);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        String S = "ab";
        String[] expected = {"ab", "ba"};
        String[] actual = solutionI0807.permutation(S);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
