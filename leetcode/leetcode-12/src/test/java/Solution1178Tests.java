import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1178Tests {
    private final Solution1178 solution1178 = new Solution1178();

    @Test
    public void example1() {
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        List<Integer> expected = List.of(1, 1, 3, 2, 4, 0);
        Assertions.assertEquals(expected, solution1178.findNumOfValidWords(words, puzzles));
    }
}
