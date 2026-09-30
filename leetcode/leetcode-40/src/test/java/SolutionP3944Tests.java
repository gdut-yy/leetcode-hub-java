import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3944Tests {
    private final SolutionP3944 solutionP3944 = new SolutionP3944();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 8};
        int k = 3;
        long expected = 2;
        Assertions.assertEquals(expected, solutionP3944.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int k = 3;
        long expected = 1;
        Assertions.assertEquals(expected, solutionP3944.minOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {6, 7, 8};
        int k = 2;
        long expected = 0;
        Assertions.assertEquals(expected, solutionP3944.minOperations(nums, k));
    }
}
