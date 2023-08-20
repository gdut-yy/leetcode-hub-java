import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution7004Tests {
    private final Solution7004 solution7004 = new Solution7004();

    @Test
    public void example1() {
        List<String> words = List.of("alice", "bob", "charlie");
        String s = "abc";
        Assertions.assertTrue(solution7004.isAcronym(words, s));
    }

    @Test
    public void example2() {
        List<String> words = List.of("an", "apple");
        String s = "a";
        Assertions.assertFalse(solution7004.isAcronym(words, s));
    }

    @Test
    public void example3() {
        List<String> words = List.of("never", "gonna", "give", "up", "on", "you");
        String s = "ngguoy";
        Assertions.assertTrue(solution7004.isAcronym(words, s));
    }
}