import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3890Tests {
    private final Solution3890 solution3890 = new Solution3890();

    @Test
    public void example1() {
        int n = 4104;
        List<Integer> expected = List.of(1729, 4104);
        Assertions.assertEquals(expected, solution3890.findGoodIntegers(n));
    }

    @Test
    public void example2() {
        int n = 578;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution3890.findGoodIntegers(n));
    }
}