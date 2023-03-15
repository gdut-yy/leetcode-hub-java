package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SegmentTreeTests {
    @Test
    public void test() {
        int[] nums = {1, 3, 5};
        int N = nums.length;
        SegmentTree segmentTree = new SegmentTree(nums);
        // [0,2]
        Assertions.assertEquals(9, segmentTree.getSum(0+1, 2+1, 1, N, 1));

        // update
        segmentTree.update(1+1, 1+1, 2, 1, N, 1);

        // [0,2]
        Assertions.assertEquals(8, segmentTree.getSum(0+1, 2+1, 1, N, 1));
    }
}
