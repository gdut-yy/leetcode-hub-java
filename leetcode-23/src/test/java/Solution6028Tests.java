import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6028Tests {
    private final Solution6028 solution6028 = new Solution6028();

    @Test
    public void example1() {
        String directions = "RLRSLL";
        int expected = 5;
        Assertions.assertEquals(expected, solution6028.countCollisions(directions));
    }

    @Test
    public void example2() {
        String directions = "LLRR";
        int expected = 0;
        Assertions.assertEquals(expected, solution6028.countCollisions(directions));
    }
}
