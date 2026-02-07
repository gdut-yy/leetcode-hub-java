import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3735Tests {
    private final SolutionP3735 solutionP3735 = new SolutionP3735();

    @Test
    public void example1() {
        String s = "dcab";
        String expected = "acdb";
        Assertions.assertEquals(expected, solutionP3735.lexSmallest(s));
    }

    @Test
    public void example2() {
        String s = "abba";
        String expected = "aabb";
        Assertions.assertEquals(expected, solutionP3735.lexSmallest(s));
    }

    @Test
    public void example3() {
        String s = "zxy";
        String expected = "xzy";
        Assertions.assertEquals(expected, solutionP3735.lexSmallest(s));
    }
}