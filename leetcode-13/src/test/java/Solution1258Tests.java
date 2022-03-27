import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1258Tests {
    private final Solution1258 solution1258 = new Solution1258();

    @Test
    public void example1() {
        List<List<String>> synonyms = List.of(List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful"));
        String text = "I am happy today but was sad yesterday";
        List<String> expected = List.of(
                "I am cheerful today but was sad yesterday",
                "I am cheerful today but was sorrow yesterday",
                "I am happy today but was sad yesterday",
                "I am happy today but was sorrow yesterday",
                "I am joy today but was sad yesterday",
                "I am joy today but was sorrow yesterday"
        );
        Assertions.assertEquals(expected, solution1258.generateSentences(synonyms, text));
    }
}
