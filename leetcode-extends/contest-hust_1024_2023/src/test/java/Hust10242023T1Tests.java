import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hust10242023T1Tests {
    private final Hust10242023T1 solution = new Hust10242023T1();

    @Test
    public void example1() {
        String moves = "UD";
        Assertions.assertTrue(solution.perfectPerformance(moves));
    }

    @Test
    public void example2() {
        String moves = "LL";
        Assertions.assertFalse(solution.perfectPerformance(moves));
    }
}
