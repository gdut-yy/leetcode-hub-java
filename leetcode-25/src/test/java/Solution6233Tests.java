import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6233Tests {
    private final Solution6233 solution6233 = new Solution6233();

    @Test
    public void example1() {
        double celsius = 36.50;
        double[] expected = {309.65000, 97.70000};
        Assertions.assertArrayEquals(expected, solution6233.convertTemperature(celsius));
    }

    @Test
    public void example2() {
        double celsius = 122.11;
        double[] expected = {395.26000, 251.79800};
        Assertions.assertArrayEquals(expected, solution6233.convertTemperature(celsius));
    }
}
