import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5980Tests {
    private final Solution5980 solution5980 = new Solution5980();

    @Test
    public void example1() {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String[] expected = {"abc", "def", "ghi"};
        Assertions.assertArrayEquals(expected, solution5980.divideString(s, k, fill));
    }

    @Test
    public void example2() {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        String[] expected = {"abc", "def", "ghi", "jxx"};
        Assertions.assertArrayEquals(expected, solution5980.divideString(s, k, fill));
    }
}
