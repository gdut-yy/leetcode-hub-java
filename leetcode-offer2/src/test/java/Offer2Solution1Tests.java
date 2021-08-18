import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer2Solution1Tests {
    private final Offer2Solution1 offer2Solution1 = new Offer2Solution1();

    @Test
    public void example1() {
        int a = 15;
        int b = 2;
        int expected = 7;
        Assertions.assertEquals(expected, offer2Solution1.divide(a, b));
    }

    @Test
    public void example2() {
        int a = 7;
        int b = -3;
        int expected = -2;
        Assertions.assertEquals(expected, offer2Solution1.divide(a, b));
    }

    @Test
    public void example3() {
        int a = 0;
        int b = 1;
        int expected = 0;
        Assertions.assertEquals(expected, offer2Solution1.divide(a, b));
    }

    @Test
    public void example4() {
        int a = 1;
        int b = 1;
        int expected = 1;
        Assertions.assertEquals(expected, offer2Solution1.divide(a, b));
    }
}
