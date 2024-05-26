import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution293Tests {
    private final Solution293 solution293 = new Solution293();

    @Test
    public void example1() {
        String currentState = "++++";
        List<String> expected = Arrays.asList("--++", "+--+", "++--");
        Assertions.assertEquals(expected, solution293.generatePossibleNextMoves(currentState));
    }

    @Test
    public void example2() {
        String currentState = "+";
        List<String> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution293.generatePossibleNextMoves(currentState));
    }
}