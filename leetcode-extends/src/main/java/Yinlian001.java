import java.util.ArrayList;
import java.util.List;

public class Yinlian001 {
    public boolean isPalindrome(ListNode head) {
        int[] nums = toArray(head);

        // 双指针
        int left = 0;
        int right = nums.length - 1;
        // 删除一个节点后
        boolean remove = false;
        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else {
                if (!remove) {
                    if (nums[left + 1] == nums[right]) {
                        left += 2;
                        right--;
                        remove = true;
                    } else if (nums[left] == nums[right - 1]) {
                        left++;
                        right -= 2;
                        remove = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] toArray(ListNode head) {
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
/*
银联-01. 回文链表
https://leetcode-cn.com/contest/cnunionpay-2022spring/problems/D7rekZ/

给定一个链表的头结点 head，判断链表删除一个节点后是否可以成为「回文链表」。
若可以，则返回 true；否则返回 false
注意：
输入用例均保证链表长度 大于等于 3
提示：
链表中节点数目在范围 [3, 10^5]
0 <= Node.val <= 10

双指针，贪心。
 */