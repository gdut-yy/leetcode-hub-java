import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100126Tests {
    private final Solution100126 solution100126 = new Solution100126();

    @Test
    public void example1() {
        int n = 4;
        int expected = 12;
        Assertions.assertEquals(expected, solution100126.stringCount(n));
        Assertions.assertEquals(expected, solution100126.stringCount2(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 83943898;
        Assertions.assertEquals(expected, solution100126.stringCount(n));
        Assertions.assertEquals(expected, solution100126.stringCount2(n));
    }
}