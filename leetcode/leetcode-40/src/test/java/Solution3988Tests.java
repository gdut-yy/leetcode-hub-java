import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3988Tests {
    private final Solution3988 solution3988 = new Solution3988();

    @Test
    public void example1() {
        int m = 2;
        int n = 3;
        int k = 2;
        String[] expected = {"...", "#.."};
        Assertions.assertArrayEquals(expected, solution3988.createGrid(m, n, k));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 3;
        int k = 4;
        String[] expected = {"..#", "...", "#.."};
        Assertions.assertArrayEquals(expected, solution3988.createGrid(m, n, k));
    }

    @Test
    public void example3() {
        int m = 1;
        int n = 4;
        int k = 2;
        String[] expected = {};
        Assertions.assertArrayEquals(expected, solution3988.createGrid(m, n, k));
    }
}