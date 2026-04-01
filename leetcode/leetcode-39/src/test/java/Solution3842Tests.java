import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3842Tests {
    private final Solution3842 solution3842 = new Solution3842();

    @Test
    public void example1() {
        List<Integer> bulbs = List.of(10, 30, 20, 10);
        List<Integer> expected = List.of(20, 30);
        Assertions.assertEquals(expected, solution3842.toggleLightBulbs(bulbs));
    }

    @Test
    public void example2() {
        List<Integer> bulbs = List.of(100, 100);
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution3842.toggleLightBulbs(bulbs));
    }
}