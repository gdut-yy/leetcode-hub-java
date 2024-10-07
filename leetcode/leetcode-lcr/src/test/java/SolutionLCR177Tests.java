import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionLCR177Tests {
    private final SolutionLCR177 solutionLCR177 = new SolutionLCR177();

    @Test
    public void example1() {
        int[] nums = {4, 1, 4, 6};
        int[] expected = {1, 6};
        int[] actual = solutionLCR177.sockCollocation(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] expected = {2, 10};
        int[] actual = solutionLCR177.sockCollocation(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
