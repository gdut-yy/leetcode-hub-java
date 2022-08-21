import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6156Tests {
    private final Solution6156 solution6156 = new Solution6156();

    @Test
    public void example1() {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution6156.minimumRecolors(blocks, k));
    }

    @Test
    public void example2() {
        String blocks = "WBWBBBW";
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution6156.minimumRecolors(blocks, k));
    }
}
