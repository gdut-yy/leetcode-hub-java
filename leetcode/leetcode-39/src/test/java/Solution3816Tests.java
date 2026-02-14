import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3816Tests {
    private final Solution3816 solution3816 = new Solution3816();

    @Test
    public void example1() {
        String s = "aaccb";
        String expected = "aacb";
        Assertions.assertEquals(expected, solution3816.lexSmallestAfterDeletion(s));
    }

    @Test
    public void example2() {
        String s = "z";
        String expected = "z";
        Assertions.assertEquals(expected, solution3816.lexSmallestAfterDeletion(s));
    }
}