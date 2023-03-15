import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1606Tests {
    private final SolutionI1606 solutionI1606 = new SolutionI1606();

    @Test
    public void example1() {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        int expected = 3;
        Assertions.assertEquals(expected, solutionI1606.smallestDifference(a, b));
    }

    // 补充用例
    @Test
    public void example2() {
        int[] a = {-2147483648, 1};
        int[] b = {2147483647, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solutionI1606.smallestDifference(a, b));
    }
}