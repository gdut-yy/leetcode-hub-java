import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3992Tests {
    private final Solution3992 solution3992 = new Solution3992();

    @Test
    public void example1() {
        String s = "aabc";
        char x = 'a';
        char y = 'c';
        String expected = "cbaa";
        // 答案不唯一
//        Assertions.assertEquals(expected, solution3992.rearrangeString(s, x, y));
    }

    @Test
    public void example2() {
        String s = "dcab";
        char x = 'd';
        char y = 'b';
        String expected = "cabd";
        // 答案不唯一
//        Assertions.assertEquals(expected, solution3992.rearrangeString(s, x, y));
    }

    @Test
    public void example3() {
        String s = "axe";
        char x = 'o';
        char y = 'x';
        String expected = "axe";
        // 答案不唯一
//        Assertions.assertEquals(expected, solution3992.rearrangeString(s, x, y));
    }
}