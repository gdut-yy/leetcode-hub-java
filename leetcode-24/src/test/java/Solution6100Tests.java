import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6100Tests {
    private final Solution6100 solution6100 = new Solution6100();

    @Test
    public void example1() {
        int n = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution6100.countHousePlacements(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 9;
        Assertions.assertEquals(expected, solution6100.countHousePlacements(n));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 1000;
        int expected = 500478595;
        Assertions.assertEquals(expected, solution6100.countHousePlacements(n));
    }
}
