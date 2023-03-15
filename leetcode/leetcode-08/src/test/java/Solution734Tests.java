import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution734Tests {
    private final Solution734 solution734 = new Solution734();

    @Test
    public void example1() {
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["great","fine"],["drama","acting"],["skills","talent"]]
                """);
        Assertions.assertTrue(solution734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example2() {
        String[] sentence1 = {"great"};
        String[] sentence2 = {"great"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                []
                """);
        Assertions.assertTrue(solution734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example3() {
        String[] sentence1 = {"great"};
        String[] sentence2 = {"doubleplus", "good"};
        List<List<String>> similarPairs = UtUtils.stringToStringList2("""
                [["great","doubleplus"]]
                """);
        Assertions.assertFalse(solution734.areSentencesSimilar(sentence1, sentence2, similarPairs));
    }
}