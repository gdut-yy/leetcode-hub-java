import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4023Tests {
    private final Solution4023 solution4023 = new Solution4023();

    @Test
    public void example1() {
        int n = 6;
        int start = 4;
        int[] requests = {1, 5};
        long expected = 6;
        Assertions.assertEquals(expected, solution4023.elevatorRequests(n, start, requests));
    }

    @Test
    public void example2() {
        int n = 8;
        int start = 3;
        int[] requests = {3, 7, 1};
        long expected = 10;
        Assertions.assertEquals(expected, solution4023.elevatorRequests(n, start, requests));
    }

    @Test
    public void example3() {
        int n = 10;
        int start = 5;
        int[] requests = {0, 2, 9};
        long expected = 22;
        Assertions.assertEquals(expected, solution4023.elevatorRequests(n, start, requests));
    }
}