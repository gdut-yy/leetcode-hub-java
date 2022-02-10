import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1447Tests {
    private final Solution1447 solution1447 = new Solution1447();

    @Test
    public void example1() {
        int n = 2;
        List<String> expected = Arrays.asList("1/2");
        List<String> actual = solution1447.simplifiedFractions(n);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 3;
        List<String> expected = Arrays.asList("1/2", "1/3", "2/3");
        List<String> actual = solution1447.simplifiedFractions(n);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int n = 4;
        List<String> expected = Arrays.asList("1/2", "1/3", "1/4", "2/3", "3/4");
        List<String> actual = solution1447.simplifiedFractions(n);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        int n = 1;
        List<String> expected = Arrays.asList();
        Assertions.assertEquals(expected, solution1447.simplifiedFractions(n));
    }
}
