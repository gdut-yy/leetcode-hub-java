import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3422Tests {
    private final SolutionP3422.V1 solutionP3422_v1 = new SolutionP3422.V1();
    private final SolutionP3422.V2 solutionP3422_v2 = new SolutionP3422.V2();

    @Test
    public void example1() {
        int[] nums = {4, -3, 2, 1, -4, 6};
        int k = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solutionP3422_v1.minOperations(nums, k));
        Assertions.assertEquals(expected, solutionP3422_v2.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-2, -2, 3, 1, 4};
        int k = 2;
        long expected = 0;
        Assertions.assertEquals(expected, solutionP3422_v1.minOperations(nums, k));
        Assertions.assertEquals(expected, solutionP3422_v2.minOperations(nums, k));
    }
}