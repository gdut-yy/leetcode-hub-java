import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0207Tests {
    private final SolutionI0207 solutionI0207 = new SolutionI0207();

    @Test
    public void example1() {
        // headC 为相交部分
        ListNode headC = new ListNode(8);
        headC.next = new ListNode(4);
        headC.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = headC;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headC;
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solutionI0207.getIntersectionNode(headA, headB));
    }

    @Test
    public void example2() {
        // headC 为相交部分
        ListNode headC = new ListNode(2);
        headC.next = new ListNode(4);

        ListNode headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = headC;
        ListNode headB = new ListNode(3);
        headB.next = headC;
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solutionI0207.getIntersectionNode(headA, headB));
    }

    @Test
    public void example3() {
        // headC 为相交部分
        ListNode headC = null;

        ListNode headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);
        // expected
        ListNode expected = headC;
        Assertions.assertEquals(expected, solutionI0207.getIntersectionNode(headA, headB));
    }
}

