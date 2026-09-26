import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hust10242023T4Tests {
    private final Hust10242023T4 solution = new Hust10242023T4();

    @Test
    public void example1() {
        String s = "11";
        int expected = 3;
        Assertions.assertEquals(expected, solution.beautifulString(s));
    }

    @Test
    public void example2() {
        String s = "01001";
        int expected = 17;
        Assertions.assertEquals(expected, solution.beautifulString(s));
    }
}
