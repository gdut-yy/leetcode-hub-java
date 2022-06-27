import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution444Tests {
    private final Solution444 solution444 = new Solution444();

    @Test
    public void example1() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3]]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example2() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2]]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example3() {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3],[2,3]]");
        Assertions.assertTrue(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example4() {
        int[] org = {4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[5,2,6,3],[4,1,5,2]]");
        Assertions.assertTrue(solution444.sequenceReconstruction(org, seqs));
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/239181254/
        int[] org = {1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/239183089/
        int[] org = {1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,1]]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example7() {
        // https://leetcode.cn/submissions/detail/239226122/
        int[] org = {3, 2, 1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[1,2],[1,3],[2,3]]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }

    @Test
    public void example8() {
        // https://leetcode.cn/submissions/detail/239227389/
        int[] org = {5, 3, 2, 4, 1};
        List<List<Integer>> seqs = UtUtils.stringToIntegerList2("[[5,3,2,4],[4,1],[1],[3],[2,4],[1000000000]]");
        Assertions.assertFalse(solution444.sequenceReconstruction(org, seqs));
    }
}