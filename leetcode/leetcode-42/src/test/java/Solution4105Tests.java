import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4105Tests {
    private final Solution4105 solution4105 = new Solution4105();

    @Test
    public void example1() {
        String a = "ab";
        String b = "abab";
        int x = 2;
        int y = 1;
        Assertions.assertTrue(solution4105.repeatedStringMatch(a, b, x, y));
    }

    @Test
    public void example2() {
        String a = "abc";
        String b = "bc";
        int x = 2;
        int y = 3;
        Assertions.assertFalse(solution4105.repeatedStringMatch(a, b, x, y));
    }

    @Test
    public void example3() {
        String a = "abcd";
        String b = "cdab";
        int x = 2;
        int y = 1;
        Assertions.assertTrue(solution4105.repeatedStringMatch(a, b, x, y));
    }
}
