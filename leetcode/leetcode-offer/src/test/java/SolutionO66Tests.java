import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO66Tests {
    private final SolutionO66 solutionO66 = new SolutionO66();

    @Test
    public void example1() {
        int[] a = {1, 2, 3, 4, 5};
        int[] expected = {120, 60, 40, 30, 24};
        Assertions.assertArrayEquals(expected, solutionO66.constructArr(a));
    }
}
