import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6185Tests {
    private final Solution6185 solution6185 = new Solution6185();

    @Test
    public void example1() {
        int[] players = {4, 7, 9};
        int[] trainers = {8, 2, 5, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solution6185.matchPlayersAndTrainers(players, trainers));
    }

    @Test
    public void example2() {
        int[] players = {1, 1, 1};
        int[] trainers = {10};
        int expected = 1;
        Assertions.assertEquals(expected, solution6185.matchPlayersAndTrainers(players, trainers));
    }
}
