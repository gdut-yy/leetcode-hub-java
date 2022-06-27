public class SolutionI0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 为 null 说明链表无环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 快慢指针相遇时，让慢指针指向头节点，然后快慢指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
/*
面试题 02.08. 环路检测
https://leetcode.cn/problems/linked-list-cycle-lcci/

给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

同: 142. 环形链表 II
https://leetcode.cn/problems/linked-list-cycle-ii/
 */