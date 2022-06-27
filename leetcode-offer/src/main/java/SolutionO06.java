import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionO06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
/*
剑指 Offer 06. 从尾到头打印链表
https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */