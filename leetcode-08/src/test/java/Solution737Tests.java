import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution737Tests {
    private final Solution737 solution737 = new Solution737();

    @Test
    public void example1() {
        String[] sentence1 = {"great", "acting", "skills"};
        String[] sentence2 = {"fine", "drama", "talent"};
        List<List<String>> similarPairs = List.of(List.of("great", "good"), List.of("fine", "good"),
                List.of("drama", "acting"), List.of("skills", "talent"));
        Assertions.assertTrue(solution737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example2() {
        String[] sentence1 = {"I", "love", "leetcode"};
        String[] sentence2 = {"I", "love", "onepiece"};
        List<List<String>> similarPairs = List.of(List.of("manga", "onepiece"), List.of("platform", "anime"),
                List.of("leetcode", "platform"), List.of("anime", "manga"));
        Assertions.assertTrue(solution737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }

    @Test
    public void example3() {
        String[] sentence1 = {"I", "love", "leetcode"};
        String[] sentence2 = {"I", "love", "onepiece"};
        List<List<String>> similarPairs = List.of(List.of("manga", "hunterXhunter"), List.of("platform", "anime"),
                List.of("leetcode", "platform"), List.of("anime", "manga"));
        Assertions.assertFalse(solution737.areSentencesSimilarTwo(sentence1, sentence2, similarPairs));
    }
}
