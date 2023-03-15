import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution422Tests {
    private final Solution422 solution422 = new Solution422();

    @Test
    public void example1() {
        List<String> words = List.of(
                "abcd",
                "bnrt",
                "crmy",
                "dtye");
        Assertions.assertTrue(solution422.validWordSquare(words));
    }

    @Test
    public void example2() {
        List<String> words = List.of(
                "abcd",
                "bnrt",
                "crm",
                "dt");
        Assertions.assertTrue(solution422.validWordSquare(words));
    }

    @Test
    public void example3() {
        List<String> words = List.of(
                "ball",
                "area",
                "read",
                "lady");
        Assertions.assertFalse(solution422.validWordSquare(words));
    }
}
