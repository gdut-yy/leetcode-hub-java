import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1183Tests {
    private final Solution1183 solution1183 = new Solution1183();

    @Test
    public void example1() {
        int width = 3;
        int height = 3;
        int sideLength = 2;
        int maxOnes = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1183.maximumNumberOfOnes(width, height, sideLength, maxOnes));
    }

    @Test
    public void example2() {
        int width = 3;
        int height = 3;
        int sideLength = 2;
        int maxOnes = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1183.maximumNumberOfOnes(width, height, sideLength, maxOnes));
    }
}