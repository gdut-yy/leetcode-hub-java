import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution6228Tests {
    private final Solution6228 solution6228 = new Solution6228();

    @Test
    public void example1() {
        String[] queries = {"word", "note", "ants", "wood"};
        String[] dictionary = {"wood", "joke", "moat"};
        List<String> expected = List.of("word", "note", "wood");
        Assertions.assertEquals(expected, solution6228.twoEditWords(queries, dictionary));
    }

    @Test
    public void example2() {
        String[] queries = {"yes"};
        String[] dictionary = {"not"};
        List<String> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution6228.twoEditWords(queries, dictionary));
    }
}
