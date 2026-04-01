import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3856Tests {
    private final Solution3856 solution3856 = new Solution3856();

    @Test
    public void example1() {
        String s = "idea";
        String expected = "id";
        Assertions.assertEquals(expected, solution3856.trimTrailingVowels(s));
    }

    @Test
    public void example2() {
        String s = "day";
        String expected = "day";
        Assertions.assertEquals(expected, solution3856.trimTrailingVowels(s));
    }

    @Test
    public void example3() {
        String s = "aeiou";
        String expected = "";
        Assertions.assertEquals(expected, solution3856.trimTrailingVowels(s));
    }
}