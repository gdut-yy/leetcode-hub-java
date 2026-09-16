import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4020Tests {
    private final Solution4020 solution4020 = new Solution4020();

    @Test
    public void example1() {
        int n = 5;
        int[] requests = {2, 1, 4, 3};
        int expected = 7;
        Assertions.assertEquals(expected, solution4020.elevatorRequests(n, requests));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] requests = {2, 0, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solution4020.elevatorRequests(n, requests));
    }
}