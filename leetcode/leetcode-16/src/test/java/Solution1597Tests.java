import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1597Tests {
    private final Solution1597 solution1597 = new Solution1597();

    @Test
    public void example1() {
        String s = "3*4-2*5";
        Solution1597.Node expected = new Solution1597.Node('-');
        expected.left = new Solution1597.Node('*');
        expected.right = new Solution1597.Node('*');
        expected.left.left = new Solution1597.Node('3');
        expected.left.right = new Solution1597.Node('4');
        expected.right.left = new Solution1597.Node('2');
        expected.right.right = new Solution1597.Node('5');
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1597.expTree(s)));
    }
}
