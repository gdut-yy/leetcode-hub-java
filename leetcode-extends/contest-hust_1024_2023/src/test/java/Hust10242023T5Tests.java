import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hust10242023T5Tests {
    private final Hust10242023T5 solution = new Hust10242023T5();

    @Test
    public void example1() {
        long n = 1;
        int k = 1;
        int m = 2;
        int[] expected = {4, 4};
        Assertions.assertArrayEquals(expected, solution.subsetCounting(n, k, m));
    }

    @Test
    public void example2() {
        long n = 1919;
        int k = 8;
        int m = 10;
        int[] expected = {577613260, 577613260, 822345879, 577613260, 822345879,
                577613260, 577613260, 822345879, 577613260, 822345879};
        Assertions.assertArrayEquals(expected, solution.subsetCounting(n, k, m));
    }
}
