import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6396Tests {
    private final Solution6396 solution6396 = new Solution6396();

    @Test
    public void example1() {
        String num1 = "1";
        String num2 = "12";
        int min_sum = 1;
        int max_sum = 8;
        int expected = 11;
        Assertions.assertEquals(expected, solution6396.count(num1, num2, min_sum, max_sum));
    }

    @Test
    public void example2() {
        String num1 = "1";
        String num2 = "5";
        int min_sum = 1;
        int max_sum = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution6396.count(num1, num2, min_sum, max_sum));
    }
}