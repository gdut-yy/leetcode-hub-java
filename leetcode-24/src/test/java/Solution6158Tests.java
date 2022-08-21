import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6158Tests {
    private final Solution6158 solution6158 = new Solution6158();

    @Test
    public void example1() {
        String s = "abc";
        int[][] shifts = UtUtils.stringToInts2("[[0,1,0],[1,2,1],[0,2,1]]");
        String expected = "ace";
        Assertions.assertEquals(expected, solution6158.shiftingLetters(s, shifts));
    }

    @Test
    public void example2() {
        String s = "dztz";
        int[][] shifts = UtUtils.stringToInts2("[[0,0,0],[1,1,1]]");
        String expected = "catz";
        Assertions.assertEquals(expected, solution6158.shiftingLetters(s, shifts));
    }
}
