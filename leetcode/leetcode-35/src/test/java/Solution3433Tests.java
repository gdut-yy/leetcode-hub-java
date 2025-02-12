import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3433Tests {
    private final Solution3433 solution3433 = new Solution3433();

    @Test
    public void example1() {
        int numberOfUsers = 2;
        List<List<String>> events = UtUtils.stringToStringList2("""
                [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
                """);
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution3433.countMentions(numberOfUsers, events));
    }

    @Test
    public void example2() {
        int numberOfUsers = 2;
        List<List<String>> events = UtUtils.stringToStringList2("""
                [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","12","ALL"]]
                """);
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution3433.countMentions(numberOfUsers, events));
    }

    @Test
    public void example3() {
        int numberOfUsers = 2;
        List<List<String>> events = UtUtils.stringToStringList2("""
                [["OFFLINE","10","0"],["MESSAGE","12","HERE"]]
                """);
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3433.countMentions(numberOfUsers, events));
    }
}