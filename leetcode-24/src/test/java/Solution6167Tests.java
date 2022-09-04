import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6167Tests {
    private final Solution6167 solution6167 = new Solution6167();

    @Test
    public void example1() {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertTrue(solution6167.checkDistances(s, distance));
    }

    @Test
    public void example2() {
        String s = "aa";
        int[] distance = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertFalse(solution6167.checkDistances(s, distance));
    }
}
