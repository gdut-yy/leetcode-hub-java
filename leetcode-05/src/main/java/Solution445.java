import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = solution206reverseList(l1);
        ListNode reverseL2 = solution206reverseList(l2);
        ListNode res = solution2addTwoNumbers(reverseL1, reverseL2);
        // 反转链表后返回
        return solution206reverseList(res);
    }

    private ListNode solution206reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode solution2addTwoNumbers(ListNode l1, ListNode l2) {
        // 使用栈还原倒序链表
        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.push(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            stack1.push(l1.val);
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            stack2.push(l2.val);
        }

        // 还原出整数 BigInteger 进行相加
        StringBuilder stringBuilder1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            stringBuilder1.append(stack1.pop());
        }
        BigInteger bigInteger1 = new BigInteger(stringBuilder1.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            stringBuilder2.append(stack2.pop());
        }
        BigInteger bigInteger2 = new BigInteger(stringBuilder2.toString());
        String resStr = bigInteger1.add(bigInteger2).toString();

        // 还原为 ListNode 返回
        ListNode res = new ListNode();
        ListNode dummy = res;
        for (int i = resStr.length() - 1; i >= 0; i--) {
            res.next = new ListNode(resStr.charAt(i) - '0');
            res = res.next;
        }
        return dummy.next;
    }
}
/*
445. 两数相加 II
https://leetcode.cn/problems/add-two-numbers-ii/

给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
提示：
链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0
进阶：如果输入链表不能翻转该如何解决？

本题是第 2 题两数相加 https://leetcode.cn/problems/add-two-numbers/ 的升级版
区别是反转了链表
反转链表可参考 第 206 题反转链表 https://leetcode.cn/problems/reverse-linked-list/
 */