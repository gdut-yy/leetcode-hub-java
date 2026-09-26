import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hust10242023T2Tests {
    private final Hust10242023T2 solution = new Hust10242023T2();

    @Test
    public void example1() {
        int[] chopsticks = {3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution.specialChopsticks(chopsticks));
    }

    @Test
    public void example2() {
        int[] chopsticks = {0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution.specialChopsticks(chopsticks));
    }

    @Test
    public void example3() {
        int[] chopsticks = {0, 4, 3, 0, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution.specialChopsticks(chopsticks));
    }

    @Test
    public void example4() {
        int[] chopsticks = {3, 6, 7, 7, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution.specialChopsticks(chopsticks));
    }
}
