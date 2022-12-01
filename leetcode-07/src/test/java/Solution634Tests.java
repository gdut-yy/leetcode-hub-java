import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution634Tests {
    private final Solution634 solution634 = new Solution634();

    @Test
    public void example1() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution634.findDerangement(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution634.findDerangement(n));
    }
}
