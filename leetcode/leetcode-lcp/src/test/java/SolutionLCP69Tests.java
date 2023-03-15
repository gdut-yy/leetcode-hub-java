import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP69Tests {
    private final SolutionLCP69 solutionLCP69 = new SolutionLCP69();
    private final SolutionLCP69_2 solutionLCP69_2 = new SolutionLCP69_2();

    @Test
    public void example1() {
        String[] words = {"hold", "engineer", "cost", "level"};
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP69.Leetcode(words));
        Assertions.assertEquals(expected, solutionLCP69_2.Leetcode(words));
    }

    @Test
    public void example2() {
        String[] words = {"hello", "leetcode"};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP69.Leetcode(words));
        Assertions.assertEquals(expected, solutionLCP69_2.Leetcode(words));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/370841468/
        // TLE
        String[] words = {"lxynxj", "wedscek", "teqmnx", "dofcm", "virxzdam", "kvovmo", "teievuso", "oqowltt", "mec", "kn", "webglrbx", "zjwpce", "cv", "cd", "poolhd"};
        int expected = 9;
        Assertions.assertEquals(expected, solutionLCP69.Leetcode(words));
        Assertions.assertEquals(expected, solutionLCP69_2.Leetcode(words));
    }
}
