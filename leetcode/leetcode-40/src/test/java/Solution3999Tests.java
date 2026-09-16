import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3999Tests {
    private final Solution3999 solution3999 = new Solution3999();

    @Test
    public void example1() {
        String[] words = {"ntgwz", "zwntg"};
        int expected = 1;
        Assertions.assertEquals(expected, solution3999.minimumGroups(words));
    }

    @Test
    public void example2() {
        String[] words = {"abc","cab","bac","acb","bca","cba"};
        int expected = 3;
        Assertions.assertEquals(expected, solution3999.minimumGroups(words));
    }

    @Test
    public void example3() {
        String[] words = {"leet","abb","bab","deed","edde","code","bba"};
        int expected = 5;
        Assertions.assertEquals(expected, solution3999.minimumGroups(words));
    }
}