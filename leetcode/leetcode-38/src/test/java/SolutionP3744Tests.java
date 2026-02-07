import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3744Tests {
    private final SolutionP3744 solutionP3744 = new SolutionP3744();

    @Test
    public void example1() {
        String s = "hello world";
        long k = 0;
        char expected = 'h';
        Assertions.assertEquals(expected, solutionP3744.kthCharacter(s, k));
    }

    @Test
    public void example2() {
        String s = "hello world";
        long k = 15;
        char expected = ' ';
        Assertions.assertEquals(expected, solutionP3744.kthCharacter(s, k));
    }
}