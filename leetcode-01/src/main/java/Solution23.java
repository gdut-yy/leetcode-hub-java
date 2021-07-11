import java.util.Objects;
import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                priorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p0 = dummy;
        while (!priorityQueue.isEmpty()) {
            p0.next = new ListNode(priorityQueue.poll());
            p0 = p0.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        // junit
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // junit
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        // junit
        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
/*
23. 合并K个升序链表
https://leetcode-cn.com/problems/merge-k-sorted-lists/

可以参考 21 题的解法，分治法。
优先队列法不易出错。
 */