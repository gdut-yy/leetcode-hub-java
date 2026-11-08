import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution4106Tests {
    private final Solution4106 solution4106 = new Solution4106();

    @Test
    public void example1() {
        String s1 = "earth";
        String s2 = "empty";
        List<List<String>> expected = List.of(List.of("ar", "mp"), List.of("h", "y"));
        Assertions.assertEquals(expected, solution4106.findMismatchedSegments(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "action";
        String s2 = "nation";
        List<List<String>> expected = List.of(List.of("ac", "na"));
        Assertions.assertEquals(expected, solution4106.findMismatchedSegments(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "hot";
        String s2 = "hot";
        List<List<String>> expected = List.of();
        Assertions.assertEquals(expected, solution4106.findMismatchedSegments(s1, s2));
    }
}
