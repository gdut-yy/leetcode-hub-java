import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Yinlian003Tests {
    private final Yinlian003 yinlian003 = new Yinlian003();

    @Test
    public void example1() {
        int[] product = {4, 5, 3};
        int limit = 8;
        int expected = 26;
        Assertions.assertEquals(expected, yinlian003.maxInvestment(product, limit));
    }

    @Test
    public void example2() {
        int[] product = {2, 1, 3};
        int limit = 20;
        int expected = 10;
        Assertions.assertEquals(expected, yinlian003.maxInvestment(product, limit));
    }
}
