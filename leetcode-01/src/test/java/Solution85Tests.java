import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution85Tests {
    private final Solution85 solution85 = new Solution85();

    @Test
    public void example1() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int expected = 6;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example2() {
        char[][] matrix = {};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example3() {
        char[][] matrix = {{'0'}};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example4() {
        char[][] matrix = {{'1'}};
        int expected = 1;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example5() {
        char[][] matrix = {{'0', '0'}};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }
}
