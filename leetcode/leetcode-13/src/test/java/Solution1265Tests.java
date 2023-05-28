import org.junit.jupiter.api.Test;

public class Solution1265Tests {
    private final Solution1265 solution1265 = new Solution1265();

    // TODO
    private static class ImmutableListNodeImpl implements Solution1265.ImmutableListNode {
        public ImmutableListNodeImpl(int[] head) {
        }

        @Override
        public void printValue() {

        }

        @Override
        public Solution1265.ImmutableListNode getNext() {
            return null;
        }
    }

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4};
        Solution1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }

    @Test
    public void example2() {
        int[] arr = {0, -4, -1, 3, -5};
        Solution1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }

    @Test
    public void example3() {
        int[] arr = {-2, 0, 6, 4, 4, -6};
        Solution1265.ImmutableListNode head = new ImmutableListNodeImpl(arr);

    }
}