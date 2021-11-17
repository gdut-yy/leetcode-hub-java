import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1001Tests {
    private final SolutionI1001 solutionI1001 = new SolutionI1001();

    @Test
    public void example1() {
        int[] A = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        solutionI1001.merge(A, m, B, n);
        Assertions.assertArrayEquals(expected, A);
    }
}
