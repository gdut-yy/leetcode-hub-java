import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SfTech220619T2Tests {
    private final SfTech220619T2 sfTech220619T2 = new SfTech220619T2();

    @Test
    public void example1() {
        int[] N = {8, 1, 12, 7, 9, 7};
        int V = 11;
        int expected = 1;
        Assertions.assertEquals(expected, sfTech220619T2.minRemainingSpace(N, V));
    }

    @Test
    public void example2() {
        int[] N = {8, 2, 12, 7, 9, 7};
        int V = 11;
        int expected = 0;
        Assertions.assertEquals(expected, sfTech220619T2.minRemainingSpace(N, V));
    }

    @Test
    public void example3() {
        int[] N = {8, 2, 12, 7, 9, 7};
        int V = 100;
        int expected = 55;
        Assertions.assertEquals(expected, sfTech220619T2.minRemainingSpace(N, V));
    }

    @Test
    public void example4() {
        int[] N = {8, 19, 18, 23, 16, 20};
        int V = 5;
        int expected = 5;
        Assertions.assertEquals(expected, sfTech220619T2.minRemainingSpace(N, V));
    }
}
