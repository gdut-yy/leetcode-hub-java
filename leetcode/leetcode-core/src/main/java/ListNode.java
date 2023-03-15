import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    // fastjson
    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    /**
     * 自定义断言
     *
     * @param expected 期望值
     * @param actual   实际值
     * @return true 相等
     */
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

    /**
     * 构造 ListNode
     *
     * @param nums nums
     * @return ListNode
     */
    public static ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * ListNode 转 int[]
     *
     * @param head head
     * @return int[]
     */
    public static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
