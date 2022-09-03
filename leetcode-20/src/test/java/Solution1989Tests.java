import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1989Tests {
    private final Solution1989 solution1989 = new Solution1989();

    @Test
    public void example1() {
        int[] team = {0, 1, 0, 1, 0};
        int dist = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1989.catchMaximumAmountofPeople(team, dist));
    }

    @Test
    public void example2() {
        int[] team = {1};
        int dist = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1989.catchMaximumAmountofPeople(team, dist));
    }

    @Test
    public void example3() {
        int[] team = {0};
        int dist = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1989.catchMaximumAmountofPeople(team, dist));
    }
}
