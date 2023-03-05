import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6307Tests {
    private final Solution6307 solution6307 = new Solution6307();

    @Test
    public void example1() {
        int n = 4;
        int time = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution6307.passThePillow(n, time));
    }

    @Test
    public void example2() {
        int n = 3;
        int time = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution6307.passThePillow(n, time));
    }
}