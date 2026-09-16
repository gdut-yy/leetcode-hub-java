import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3995Tests {
    private final Solution3995 solution3995 = new Solution3995();

    @Test
    public void example1() {
        String source = "hello";
        String target = "world";
        List<List<String>> rules = UtUtils.stringToStringList2("""
                [["he","wo"],["llo","rld"]]
                """);
        int[] costs = {3, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution3995.minCost(source, target, rules, costs));
    }

    @Test
    public void example2() {
        String source = "cat";
        String target = "dog";
        List<List<String>> rules = UtUtils.stringToStringList2("""
                [["c*t","dog"]]
                """);
        int[] costs = {2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3995.minCost(source, target, rules, costs));
    }

    @Test
    public void example3() {
        String source = "test";
        String target = "next";
        List<List<String>> rules = UtUtils.stringToStringList2("""
                [["*e*t","next"]]
                """);
        int[] costs = {4};
        int expected = 6;
        Assertions.assertEquals(expected, solution3995.minCost(source, target, rules, costs));
    }

    @Test
    public void example4() {
        String source = "ab";
        String target = "bc";
        List<List<String>> rules = UtUtils.stringToStringList2("""
                [["a*","bd"]]
                """);
        int[] costs = {9};
        int expected = -1;
        Assertions.assertEquals(expected, solution3995.minCost(source, target, rules, costs));
    }
}