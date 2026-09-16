import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4043Tests {
    private final Solution4043 solution4043 = new Solution4043();

    @Test
    public void example1() {
        String s = "aab";
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution4043.countRotations(s, k));
    }

    @Test
    public void example2() {
        String s = "abca";
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution4043.countRotations(s, k));
    }
}