import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6128Tests {
    private final Solution6128 solution6128 = new Solution6128();

    @Test
    public void example1() {
        int[] ranks = {13, 2, 3, 1, 9};
        char[] suits = UtUtils.stringToChars("""
                ["a","a","a","a","a"]
                """);
        String expected = "Flush";
        Assertions.assertEquals(expected, solution6128.bestHand(ranks, suits));
    }

    @Test
    public void example2() {
        int[] ranks = {4, 4, 2, 4, 4};
        char[] suits = UtUtils.stringToChars("""
                ["d","a","a","b","c"]
                 """);
        String expected = "Three of a Kind";
        Assertions.assertEquals(expected, solution6128.bestHand(ranks, suits));
    }

    @Test
    public void example3() {
        int[] ranks = {10, 10, 2, 12, 9};
        char[] suits = UtUtils.stringToChars("""
                ["a","b","c","a","d"]
                 """);
        String expected = "Pair";
        Assertions.assertEquals(expected, solution6128.bestHand(ranks, suits));
    }
}
