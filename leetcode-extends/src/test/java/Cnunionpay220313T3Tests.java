import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220313T3Tests {
    private final Cnunionpay220313T3 cnunionpay220313T3 = new Cnunionpay220313T3();

    @Test
    public void example1() {
        int[] product = {4, 5, 3};
        int limit = 8;
        int expected = 26;
        Assertions.assertEquals(expected, cnunionpay220313T3.maxInvestment(product, limit));
    }

    @Test
    public void example2() {
        int[] product = {2, 1, 3};
        int limit = 20;
        int expected = 10;
        Assertions.assertEquals(expected, cnunionpay220313T3.maxInvestment(product, limit));
    }
}
