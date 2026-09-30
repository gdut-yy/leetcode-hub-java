import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3991Tests {
    private final SolutionP3991 solutionP3991 = new SolutionP3991();

    @Test
    public void example1() {
        int[] nums = {2, 0, 1};
        int[] pre = {2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3991.sortArray(nums, pre));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 2};
        int[] pre = {1, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3991.sortArray(nums, pre));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1};
        int[] pre = {2};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3991.sortArray(nums, pre));
    }
}
