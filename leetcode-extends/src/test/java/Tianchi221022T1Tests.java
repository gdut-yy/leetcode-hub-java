import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tianchi221022T1Tests {
    private final Tianchi221022T1 tianchi221022T1 = new Tianchi221022T1();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1, 8});
        int expected = 1;
        Assertions.assertEquals(expected, tianchi221022T1.numberEvenListNode(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        int expected = 2;
        Assertions.assertEquals(expected, tianchi221022T1.numberEvenListNode(head));
    }
}
