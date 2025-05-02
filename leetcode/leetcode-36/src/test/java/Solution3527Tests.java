import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3527Tests {
    private final Solution3527 solution3527 = new Solution3527();

    @Test
    public void example1() {
        List<List<String>> responses = UtUtils.stringToStringList2("""
                [["good","ok","good","ok"],["ok","bad","good","ok","ok"],["good"],["bad"]]
                """);
        String expected = "good";
        Assertions.assertEquals(expected, solution3527.findCommonResponse(responses));
    }

    @Test
    public void example2() {
        List<List<String>> responses = UtUtils.stringToStringList2("""
                [["good","ok","good"],["ok","bad"],["bad","notsure"],["great","good"]]
                """);
        String expected = "bad";
        Assertions.assertEquals(expected, solution3527.findCommonResponse(responses));
    }
}