import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100263Tests {
    private final Solution100263 solution100263 = new Solution100263();

    @Test
    public void example1() {
        int x = 18;
        int expected = 9;
        Assertions.assertEquals(expected, solution100263.sumOfTheDigitsOfHarshadNumber(x));
    }

    @Test
    public void example2() {
        int x = 23;
        int expected = -1;
        Assertions.assertEquals(expected, solution100263.sumOfTheDigitsOfHarshadNumber(x));
    }
}