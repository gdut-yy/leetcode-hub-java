import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution708Tests {
    private final Solution708 solution708 = new Solution708();

    @Test
    public void example1() {
        Solution708.Node head = new Solution708.Node(3);
        head.next = new Solution708.Node(4);
        head.next.next = new Solution708.Node(1);
        head.next.next.next = head;
        int insertVal = 2;
        // expected
        Solution708.Node expected = new Solution708.Node(3);
        expected.next = new Solution708.Node(4);
        expected.next.next = new Solution708.Node(1);
        expected.next.next.next = new Solution708.Node(2);
        expected.next.next.next.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution708.insert(head, insertVal)));
    }

    @Test
    public void example2() {
        Solution708.Node head = null;
        int insertVal = 1;
        // expected
        Solution708.Node expected = new Solution708.Node(1);
        expected.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution708.insert(head, insertVal)));
    }

    @Test
    public void example3() {
        Solution708.Node head = new Solution708.Node(1);
        head.next = head;
        int insertVal = 0;
        // expected
        Solution708.Node expected = new Solution708.Node(1);
        expected.next = new Solution708.Node(0);
        expected.next.next = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution708.insert(head, insertVal)));
    }
}
