import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO40Tests {
    private final SolutionO40 solutionO40 = new SolutionO40();

    @Test
    public void example1() {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solutionO40.getLeastNumbers(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {0, 1, 2, 1};
        int k = 1;
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solutionO40.getLeastNumbers(arr, k));
    }
}
