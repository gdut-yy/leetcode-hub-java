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
}
