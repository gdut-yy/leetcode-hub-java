import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6109Tests {
    private final Solution6109 solution6109 = new Solution6109();

    @Test
    public void example1() {
        int n = 6;
        int delay = 2;
        int forget = 4;
        int expected = 5;
        Assertions.assertEquals(expected, solution6109.peopleAwareOfSecret(n, delay, forget));
    }

    @Test
    public void example2() {
        int n = 4;
        int delay = 1;
        int forget = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution6109.peopleAwareOfSecret(n, delay, forget));
    }
}
