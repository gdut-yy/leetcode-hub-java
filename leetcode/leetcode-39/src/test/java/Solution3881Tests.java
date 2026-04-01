import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3881Tests {
    private final Solution3881 solution3881 = new Solution3881();

    @Test
    public void example1() {
        int n = 3;
        int pos = 1;
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3881.countVisiblePeople(n, pos, k));
        Assertions.assertEquals(expected, solution3881.countVisiblePeople2(n, pos, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int pos = 2;
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3881.countVisiblePeople(n, pos, k));
        Assertions.assertEquals(expected, solution3881.countVisiblePeople2(n, pos, k));
    }

    @Test
    public void example3() {
        int n = 1;
        int pos = 0;
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3881.countVisiblePeople(n, pos, k));
        Assertions.assertEquals(expected, solution3881.countVisiblePeople2(n, pos, k));
    }
}