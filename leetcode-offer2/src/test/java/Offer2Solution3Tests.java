import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer2Solution3Tests {
    private final Offer2Solution3 offer2Solution3 = new Offer2Solution3();

    @Test
    public void example1() {
        int n = 2;
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, offer2Solution3.countBits(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int[] expected = {0, 1, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, offer2Solution3.countBits(n));
    }
}
