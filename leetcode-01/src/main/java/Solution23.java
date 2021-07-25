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
}
/*
23. 合并K个升序链表
https://leetcode-cn.com/problems/merge-k-sorted-lists/

可以参考 21 题的解法，分治法。
优先队列法不易出错。
 */