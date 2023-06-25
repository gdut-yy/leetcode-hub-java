import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6891Tests {
    private final Solution6891 solution6891 = new Solution6891();

    @Test
    public void example1() {
        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";
        List<Integer> expected = List.of(2, 17, 9, 15, 10);
        Assertions.assertEquals(expected, solution6891.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void example2() {
        int[] positions = {3, 5, 2, 6};
        int[] healths = {10, 10, 15, 12};
        String directions = "RLRL";
        List<Integer> expected = List.of(14);
        Assertions.assertEquals(expected, solution6891.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void example3() {
        int[] positions = {1, 2, 5, 6};
        int[] healths = {10, 10, 11, 11};
        String directions = "RLRL";
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution6891.survivedRobotsHealths(positions, healths, directions));
    }
}