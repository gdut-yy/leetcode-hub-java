import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hhrc220925T1Tests {
    private final Hhrc220925T1 hhrc220925T1 = new Hhrc220925T1();

    @Test
    public void example1() {
        int[] material = {10, 2, 6, 1};
        int expected = 1;
        Assertions.assertEquals(expected, hhrc220925T1.lastMaterial(material));
    }

    @Test
    public void example2() {
        int[] material = {6, 4, 10};
        int expected = 0;
        Assertions.assertEquals(expected, hhrc220925T1.lastMaterial(material));
    }
}
