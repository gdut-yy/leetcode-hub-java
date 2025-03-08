import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3447Tests {
    private final Solution3447 solution3447 = new Solution3447();

    @Test
    public void example1() {
        int[] groups = {8, 4, 3, 2, 4};
        int[] elements = {4, 2};
        int[] expected = {0, 0, -1, 1, 0};
        Assertions.assertArrayEquals(expected, solution3447.assignElements(groups, elements));
    }

    @Test
    public void example2() {
        int[] groups = {2, 3, 5, 7};
        int[] elements = {5, 3, 3};
        int[] expected = {-1, 1, 0, -1};
        Assertions.assertArrayEquals(expected, solution3447.assignElements(groups, elements));
    }

    @Test
    public void example3() {
        int[] groups = {10, 21, 30, 41};
        int[] elements = {2, 1};
        int[] expected = {0, 1, 0, 1};
        Assertions.assertArrayEquals(expected, solution3447.assignElements(groups, elements));
    }
}