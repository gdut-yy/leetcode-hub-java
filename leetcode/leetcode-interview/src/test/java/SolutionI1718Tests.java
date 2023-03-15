import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1718Tests {
    private final SolutionI1718 solutionI1718 = new SolutionI1718();

    @Test
    public void example1() {
        int[] big = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = {1, 5, 9};
        int[] expected = {7, 10};
        Assertions.assertArrayEquals(expected, solutionI1718.shortestSeq(big, small));
    }

    @Test
    public void example2() {
        int[] big = {1, 2, 3};
        int[] small = {4};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solutionI1718.shortestSeq(big, small));
    }
}
