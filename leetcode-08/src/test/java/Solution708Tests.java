import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution708Tests {
    private final Solution708 solution708 = new Solution708();

    @Test
    public void example1() {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        int insertVal = 2;
        // expected
        Node expected = new Node(3);
        expected.next = new Node(4);
        expected.next.next = new Node(1);
        expected.next.next.next = new Node(2);
        expected.next.next.next.next = expected;
        Assertions.assertTrue(Node.assertNodeEquals2(expected, solution708.insert(head, insertVal)));
    }

    @Test
    public void example2() {
        Node head = null;
        int insertVal = 1;
        // expected
        Node expected = new Node(1);
        expected.next = expected;
        Assertions.assertTrue(Node.assertNodeEquals2(expected, solution708.insert(head, insertVal)));
    }

    @Test
    public void example3() {
        Node head = new Node(1);
        head.next = head;
        int insertVal = 0;
        // expected
        Node expected = new Node(1);
        expected.next = new Node(0);
        expected.next.next = expected;
        Assertions.assertTrue(Node.assertNodeEquals2(expected, solution708.insert(head, insertVal)));
    }
}
