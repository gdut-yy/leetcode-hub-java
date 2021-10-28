public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    public static boolean assertListNodeEquals(ListNode expected, ListNode actual) {
        if (expected == null && actual == null) {
            return true;
        } else if (expected == null || actual == null) {
            return false;
        } else if (expected.val != actual.val) {
            return false;
        } else {
            return assertListNodeEquals(expected.next, actual.next);
        }
    }

    public static ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
