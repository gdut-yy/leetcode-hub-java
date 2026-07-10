import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3963Tests {
    private final Solution3963 solution = new Solution3963();

    @Test
    public void example1() {
        int m = 2;
        int n = 3;
        String[] expected = new String[]{"..#", "#.."};
        // 答案不唯一
//        Assertions.assertArrayEquals(expected, solution.createGrid(m, n));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 3;
        String[] expected = new String[]{"..#", "#..", "##."};
        // 答案不唯一
//        Assertions.assertArrayEquals(expected, solution.createGrid(m, n));
    }

    @Test
    public void example3() {
        int m = 1;
        int n = 4;
        String[] expected = new String[]{"...."};
        Assertions.assertArrayEquals(expected, solution.createGrid(m, n));
    }
}