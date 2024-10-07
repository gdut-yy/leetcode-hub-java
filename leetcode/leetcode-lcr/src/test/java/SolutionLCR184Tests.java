import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR184Tests {
    @Test
    public void example1() {
        SolutionLCR184.Checkout checkout = new SolutionLCR184.Checkout();
        checkout.add(1);
        checkout.add(2);
        Assertions.assertEquals(2, checkout.get_max());
        Assertions.assertEquals(1, checkout.remove());
        Assertions.assertEquals(2, checkout.get_max());
    }

    @Test
    public void example2() {
        SolutionLCR184.Checkout checkout = new SolutionLCR184.Checkout();
        Assertions.assertEquals(-1, checkout.remove());
        Assertions.assertEquals(-1, checkout.get_max());
    }
}
