import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3906Tests {
    private final Solution3906 solution3906 = new Solution3906();

    @Test
    public void example1() {
        long l = 8;
        long r = 10;
        String directions = "DDDRRR";
        long expected = 2;
        Assertions.assertEquals(expected, solution3906.countGoodIntegersOnPath(l, r, directions));
    }

    @Test
    public void example2() {
        long l = 123456789;
        long r = 123456790;
        String directions = "DDRRDR";
        long expected = 1;
        Assertions.assertEquals(expected, solution3906.countGoodIntegersOnPath(l, r, directions));
    }

    @Test
    public void example3() {
        long l = 1288561398769758L;
        long r = 1288561398769758L;
        String directions = "RRRDDD";
        long expected = 0;
        Assertions.assertEquals(expected, solution3906.countGoodIntegersOnPath(l, r, directions));
    }
}