import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6108Tests {
    private final Solution6108 solution6108 = new Solution6108();

    @Test
    public void example1() {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String expected = "this is a secret";
        Assertions.assertEquals(expected, solution6108.decodeMessage(key, message));
    }

    @Test
    public void example2() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String expected = "the five boxing wizards jump quickly";
        Assertions.assertEquals(expected, solution6108.decodeMessage(key, message));
    }
}
