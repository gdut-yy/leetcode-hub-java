import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1003Tests {
    private final SolutionI1003 solutionI1003 = new SolutionI1003();

    @Test
    public void example1() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        int expected = 8;
        Assertions.assertEquals(expected, solutionI1003.search(arr, target));
    }

    @Test
    public void example2() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 11;
        int expected = -1;
        Assertions.assertEquals(expected, solutionI1003.search(arr, target));
    }
}
