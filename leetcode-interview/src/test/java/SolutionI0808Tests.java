import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionI0808Tests {
    private final SolutionI0808 solutionI0808 = new SolutionI0808();

    @Test
    public void example1() {
        String S = "qqe";
        String[] expected = {"eqq", "qeq", "qqe"};
        String[] actual = solutionI0808.permutation(S);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        String S = "ab";
        String[] expected = {"ab", "ba"};
        String[] actual = solutionI0808.permutation(S);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
