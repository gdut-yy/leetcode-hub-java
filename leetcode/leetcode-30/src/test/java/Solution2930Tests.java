import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2930Tests {
    private final Solution2930.V1 solution2930_v1 = new Solution2930.V1();
    private final Solution2930.V2 solution2930_v2 = new Solution2930.V2();

    @Test
    public void example1() {
        int n = 4;
        int expected = 12;
        Assertions.assertEquals(expected, solution2930_v1.stringCount(n));
        Assertions.assertEquals(expected, solution2930_v2.stringCount(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 83943898;
        Assertions.assertEquals(expected, solution2930_v1.stringCount(n));
        Assertions.assertEquals(expected, solution2930_v2.stringCount(n));
    }
}