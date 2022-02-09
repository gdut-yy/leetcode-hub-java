import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1055Tests {
    private final Solution1055 solution1055 = new Solution1055();

    @Test
    public void example1() {
        String source = "abc";
        String target = "abcbc";
        int expected = 2;
        Assertions.assertEquals(expected, solution1055.shortestWay(source, target));
    }

    @Test
    public void example2() {
        String source = "abc";
        String target = "acdbc";
        int expected = -1;
        Assertions.assertEquals(expected, solution1055.shortestWay(source, target));
    }

    @Test
    public void example3() {
        String source = "xyz";
        String target = "xzyxz";
        int expected = 3;
        Assertions.assertEquals(expected, solution1055.shortestWay(source, target));
    }

    // 补充用例
    @Test
    public void example4() {
        String source = "aaaaa";
        String target = "aaaaaaaaaaaaa";
        int expected = 3;
        Assertions.assertEquals(expected, solution1055.shortestWay(source, target));
    }
}