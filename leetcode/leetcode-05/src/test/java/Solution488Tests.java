import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution488Tests {
    @Test
    public void example1() {
        String board = "WRRBBW";
        String hand = "RB";
        int expected = -1;
        Assertions.assertEquals(expected, new Solution488().findMinStep(board, hand));
    }

    @Test
    public void example2() {
        String board = "WWRRBBWW";
        String hand = "WRBRW";
        int expected = 2;
        Assertions.assertEquals(expected, new Solution488().findMinStep(board, hand));
    }

    @Test
    public void example3() {
        String board = "G";
        String hand = "GGGGG";
        int expected = 2;
        Assertions.assertEquals(expected, new Solution488().findMinStep(board, hand));
    }

    @Test
    public void example4() {
        String board = "RBYYBBRRB";
        String hand = "YRBGB";
        int expected = 3;
        Assertions.assertEquals(expected, new Solution488().findMinStep(board, hand));
    }
}
