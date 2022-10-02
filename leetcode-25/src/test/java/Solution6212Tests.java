import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6212Tests {
    private final Solution6212 solution6212 = new Solution6212();

    @Test
    public void example1() {
        String word = "abcc";
        Assertions.assertTrue(solution6212.equalFrequency(word));
    }

    @Test
    public void example2() {
        String word = "aazz";
        Assertions.assertFalse(solution6212.equalFrequency(word));
    }
}
