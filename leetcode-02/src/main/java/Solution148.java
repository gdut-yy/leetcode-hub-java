import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        int[] nums = listNode2Ints(head);
        Arrays.sort(nums);
        return ints2ListNode(nums);
    }

    private int[] listNode2Ints(ListNode head) {
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

    private ListNode ints2ListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
/*
148. 排序链表
https://leetcode-cn.com/problems/sort-list/

麻瓜做法: 转成数组 => 排序 => 重建链表
实际考察的是归并排序
 */