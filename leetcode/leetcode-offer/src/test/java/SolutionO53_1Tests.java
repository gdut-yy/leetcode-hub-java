import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO53_1Tests {
    private final SolutionO53_1 solutionO53_1 = new SolutionO53_1();

    @Test
    public void example1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solutionO53_1.search(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solutionO53_1.search(nums, target));
    }
}
