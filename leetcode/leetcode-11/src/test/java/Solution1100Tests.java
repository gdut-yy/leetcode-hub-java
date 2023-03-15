import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1100Tests {
    private final Solution1100 solution1100 = new Solution1100();

    @Test
    public void example1() {
        String s = "havefunonleetcode";
        int k = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solution1100.numKLenSubstrNoRepeats(s, k));
    }

    @Test
    public void example2() {
        String s = "home";
        int k = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution1100.numKLenSubstrNoRepeats(s, k));
    }
}
