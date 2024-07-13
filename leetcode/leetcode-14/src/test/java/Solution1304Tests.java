import org.junit.jupiter.api.Test;

public class Solution1304Tests {
    private final Solution1304 solution1304 = new Solution1304();

    @Test
    public void example1() {
        int n = 5;
        int[] expected = {-7, -1, 1, 3, 4};
        int[] actual = solution1304.sumZero(n);
    }

    @Test
    public void example2() {
        int n = 3;
        int[] expected = {-1, 0, 1};
        int[] actual = solution1304.sumZero(n);
    }

    @Test
    public void example3() {
        int n = 1;
        int[] expected = {0};
        int[] actual = solution1304.sumZero(n);
    }
}