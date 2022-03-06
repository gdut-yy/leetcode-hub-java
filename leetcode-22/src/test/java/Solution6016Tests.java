import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6016Tests {
    private final Solution6016 solution6016 = new Solution6016();

    @Test
    public void example1() {
        String s = "K1:L2";
        List<String> expected = List.of("K1", "K2", "L1", "L2");
        Assertions.assertEquals(expected, solution6016.cellsInRange(s));
    }

    @Test
    public void example2() {
        String s = "A1:F1";
        List<String> expected = List.of("A1", "B1", "C1", "D1", "E1", "F1");
        Assertions.assertEquals(expected, solution6016.cellsInRange(s));
    }
}
