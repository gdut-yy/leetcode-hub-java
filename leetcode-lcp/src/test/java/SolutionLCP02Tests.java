import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP02Tests {
    private final SolutionLCP02 solutionLCP02 = new SolutionLCP02();

    @Test
    public void example1() {
        int[] cont = {3, 2, 0, 2};
        int[] expected = {13, 4};
        Assertions.assertArrayEquals(expected, solutionLCP02.fraction(cont));
    }

    @Test
    public void example2() {
        int[] cont = {0, 0, 3};
        int[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, solutionLCP02.fraction(cont));
    }
}
