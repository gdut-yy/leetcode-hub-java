import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5957Tests {
    private final Solution5957 solution5957 = new Solution5957();

    @Test
    public void example1() {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        String expected = "Leetcode Helps Me Learn";
        Assertions.assertEquals(expected, solution5957.addSpaces(s, spaces));
    }

    @Test
    public void example2() {
        String s = "icodeinpython";
        int[] spaces = {1, 5, 7, 9};
        String expected = "i code in py thon";
        Assertions.assertEquals(expected, solution5957.addSpaces(s, spaces));
    }

    @Test
    public void example3() {
        String s = "spacing";
        int[] spaces = {0, 1, 2, 3, 4, 5, 6};
        String expected = " s p a c i n g";
        Assertions.assertEquals(expected, solution5957.addSpaces(s, spaces));
    }
}
