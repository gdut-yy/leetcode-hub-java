import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5942Tests {
    private final Solution5942 solution5942 = new Solution5942();

    @Test
    public void example1() {
        int[] digits = {2, 1, 3, 0};
        int[] expected = {102, 120, 130, 132, 210, 230, 302, 310, 312, 320};
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers(digits));
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers2(digits));
    }

    @Test
    public void example2() {
        int[] digits = {2, 2, 8, 8, 2};
        int[] expected = {222, 228, 282, 288, 822, 828, 882};
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers(digits));
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers2(digits));
    }

    @Test
    public void example3() {
        int[] digits = {3, 7, 5};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers(digits));
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers2(digits));
    }

    @Test
    public void example4() {
        int[] digits = {0, 2, 0, 0};
        int[] expected = {200};
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers(digits));
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers2(digits));
    }

    @Test
    public void example5() {
        int[] digits = {0, 0, 0};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers(digits));
        Assertions.assertArrayEquals(expected, solution5942.findEvenNumbers2(digits));
    }
}
