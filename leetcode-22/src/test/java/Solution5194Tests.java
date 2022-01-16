import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5194Tests {
    private final Solution5194 solution5194 = new Solution5194();

    @Test
    public void example1() {
        int target = 5;
        int maxDoubles = 0;
        int expected = 4;
        Assertions.assertEquals(expected, solution5194.minMoves(target, maxDoubles));
    }

    @Test
    public void example2() {
        int target = 19;
        int maxDoubles = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution5194.minMoves(target, maxDoubles));
    }

    @Test
    public void example3() {
        int target = 10;
        int maxDoubles = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution5194.minMoves(target, maxDoubles));
    }

    // 补充用例
    @Test
    public void example4() {
        int target = 999999999;
        int maxDoubles = 0;
        int expected = 999999998;
        Assertions.assertEquals(expected, solution5194.minMoves(target, maxDoubles));
    }
}
