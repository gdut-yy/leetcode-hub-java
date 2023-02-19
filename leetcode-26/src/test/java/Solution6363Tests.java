import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6363Tests {
    private final Solution6363 solution6363 = new Solution6363();

    @Test
    public void example1() {
        int[][] lcp = UtUtils.stringToInts2("[[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]");
        String expected = "abab";
        Assertions.assertEquals(expected, solution6363.findTheString(lcp));
    }

    @Test
    public void example2() {
        int[][] lcp = UtUtils.stringToInts2("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]");
        String expected = "aaaa";
        Assertions.assertEquals(expected, solution6363.findTheString(lcp));
    }

    @Test
    public void example3() {
        int[][] lcp = UtUtils.stringToInts2("[[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]");
        String expected = "";
        Assertions.assertEquals(expected, solution6363.findTheString(lcp));
    }
}