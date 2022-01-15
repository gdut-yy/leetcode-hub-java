import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution841Tests {
    private final Solution841 solution841 = new Solution841();

    @Test
    public void example1() {
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
        Assertions.assertTrue(solution841.canVisitAllRooms(rooms));
    }

    @Test
    public void example2() {
        List<List<Integer>> rooms = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        Assertions.assertFalse(solution841.canVisitAllRooms(rooms));
    }
}
