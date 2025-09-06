import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3549Tests {
    private final SolutionP3549 solutionP3549 = new SolutionP3549();

    @Test
    public void example1() {
        int[] poly1 = {3, 2, 5};
        int[] poly2 = {1, 4};
        long[] expected = {3, 14, 13, 20};
        Assertions.assertArrayEquals(expected, solutionP3549.multiply(poly1, poly2));
    }

    @Test
    public void example2() {
        int[] poly1 = {1, 0, -2};
        int[] poly2 = {-1};
        long[] expected = {-1, 0, 2};
        Assertions.assertArrayEquals(expected, solutionP3549.multiply(poly1, poly2));
    }

    @Test
    public void example3() {
        int[] poly1 = {1, 5, -3};
        int[] poly2 = {-4, 2, 0};
        long[] expected = {-4, -18, 22, -6, 0};
        Assertions.assertArrayEquals(expected, solutionP3549.multiply(poly1, poly2));
    }
}