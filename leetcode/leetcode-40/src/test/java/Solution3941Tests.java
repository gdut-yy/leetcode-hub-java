import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3941Tests {
    private final Solution3941 solution3941 = new Solution3941();

    @Test
    public void example1() {
        String password = "aA1!";
        int expected = 11;
        Assertions.assertEquals(expected, solution3941.passwordStrength(password));
    }

    @Test
    public void example2() {
        String password = "bbB11#";
        int expected = 11;
        Assertions.assertEquals(expected, solution3941.passwordStrength(password));
    }
}