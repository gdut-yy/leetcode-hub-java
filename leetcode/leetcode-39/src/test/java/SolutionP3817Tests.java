import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3817Tests {
    private final SolutionP3817 solutionP3817 = new SolutionP3817();

    @Test
    public void example1() {
        String s = "0234567890112";
        List<Integer> expected = List.of(0, 11, 12);
        Assertions.assertEquals(expected, solutionP3817.goodIndices(s));
    }

    @Test
    public void example2() {
        String s = "01234";
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        Assertions.assertEquals(expected, solutionP3817.goodIndices(s));
    }

    @Test
    public void example3() {
        String s = "12345";
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solutionP3817.goodIndices(s));
    }
}
