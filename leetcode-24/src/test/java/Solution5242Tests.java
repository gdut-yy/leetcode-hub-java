import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5242Tests {
    private final Solution5242 solution5242 = new Solution5242();

    @Test
    public void example1() {
        String s = "lEeTcOdE";
        String expected = "E";
        Assertions.assertEquals(expected, solution5242.greatestLetter(s));
    }

    @Test
    public void example2() {
        String s = "arRAzFif";
        String expected = "R";
        Assertions.assertEquals(expected, solution5242.greatestLetter(s));
    }

    @Test
    public void example3() {
        String s = "AbCdEfGhIjK";
        String expected = "";
        Assertions.assertEquals(expected, solution5242.greatestLetter(s));
    }
}
