import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer2Solution2Tests {
    private final Offer2Solution2 offer2Solution2 = new Offer2Solution2();

    @Test
    public void example1() {
        String a = "11";
        String b = "10";
        String expected = "101";
        Assertions.assertEquals(expected, offer2Solution2.addBinary(a, b));
    }

    @Test
    public void example2() {
        String a = "1010";
        String b = "1011";
        String expected = "10101";
        Assertions.assertEquals(expected, offer2Solution2.addBinary(a, b));
    }
}
