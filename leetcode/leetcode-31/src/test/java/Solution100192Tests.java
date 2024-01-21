import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100192Tests {
    private final Solution100192 solution100192 = new Solution100192();

    @Test
    public void example1() {
        String word = "abcde";
        int expected = 5;
        Assertions.assertEquals(expected, solution100192.minimumPushes(word));
    }

    @Test
    public void example2() {
        String word = "xyzxyzxyzxyz";
        int expected = 12;
        Assertions.assertEquals(expected, solution100192.minimumPushes(word));
    }

    @Test
    public void example3() {
        String word = "aabbccddeeffgghhiiiiii";
        int expected = 24;
        Assertions.assertEquals(expected, solution100192.minimumPushes(word));
    }
}