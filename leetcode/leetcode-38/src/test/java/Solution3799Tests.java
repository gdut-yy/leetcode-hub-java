import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3799Tests {
    private final Solution3799 solution3799 = new Solution3799();

    @Test
    public void example1() {
        String[] words = {"able", "area", "echo", "also"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["able","area","echo","also"],["area","able","also","echo"]]
                """);
        Assertions.assertEquals(expected, solution3799.wordSquares(words));
    }

    @Test
    public void example2() {
        String[] words = {"code", "cafe", "eden", "edge"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                []
                """);
        Assertions.assertEquals(expected, solution3799.wordSquares(words));
    }
}