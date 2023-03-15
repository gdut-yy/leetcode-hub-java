import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hhrc220925T2Tests {
    private final Hhrc220925T2 hhrc220925T2 = new Hhrc220925T2();

    @Test
    public void example1() {
        int[] sales = {10, 2, 1, 4, 3, 9, 6, 9, 9};
        int expected = 5;
        Assertions.assertEquals(expected, hhrc220925T2.longestESR(sales));
    }

    @Test
    public void example2() {
        int[] sales = {5, 6, 7};
        int expected = 0;
        Assertions.assertEquals(expected, hhrc220925T2.longestESR(sales));
    }
}
