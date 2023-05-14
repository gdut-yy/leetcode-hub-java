import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP82Tests {
    private final SolutionLCP82 solutionLCP82 = new SolutionLCP82();

    @Test
    public void example1() {
        int[] gem = {2, 3};
        int p = 100000007;
        int target = 11391299;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP82.treeOfInfiniteSouls(gem, p, target));
    }

    @Test
    public void example2() {
        int[] gem = {3, 21, 3};
        int p = 7;
        int target = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP82.treeOfInfiniteSouls(gem, p, target));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/431613147/
        int[] gem = {7, 75, 393, 5486, 25179, 906116, 7313534, 34808317, 125437907};
        int p = 100000007;
        int target = 11479217;
        int expected = 21;
        Assertions.assertEquals(expected, solutionLCP82.treeOfInfiniteSouls(gem, p, target));
    }
}