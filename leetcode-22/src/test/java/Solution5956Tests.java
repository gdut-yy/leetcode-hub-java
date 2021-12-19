import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5956Tests {
    private final Solution5956 solution5956 = new Solution5956();

    @Test
    public void example1() {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String expected = "ada";
        Assertions.assertEquals(expected, solution5956.firstPalindrome(words));
    }

    @Test
    public void example2() {
        String[] words = {"notapalindrome", "racecar"};
        String expected = "racecar";
        Assertions.assertEquals(expected, solution5956.firstPalindrome(words));
    }

    @Test
    public void example3() {
        String[] words = {"def", "ghi"};
        String expected = "";
        Assertions.assertEquals(expected, solution5956.firstPalindrome(words));
    }
}
