import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1436Tests {
    private final Solution1436 solution1436 = new Solution1436();

    @Test
    public void example1() {
        List<List<String>> paths = List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"));
        String expected = "Sao Paulo";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }

    @Test
    public void example2() {
        List<List<String>> paths = List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"));
        String expected = "A";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }

    @Test
    public void example3() {
        List<List<String>> paths = List.of(List.of("A", "Z"));
        String expected = "Z";
        Assertions.assertEquals(expected, solution1436.destCity(paths));
    }
}
