import java.util.ArrayList;
import java.util.List;

public class Solution2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        int size = 1;
        for (ListNode node = head; node != null; node = node.next) {
            nodes.add(node);
            if (nodes.size() == size || node.next == null) { // 统计到 size 个节点，或到达链表末尾
                int n = nodes.size();
                if (n % 2 == 0) { // 有偶数个节点
                    for (int i = 0; i < n / 2; i++) {
                        // 直接交换元素值
                        int temp = nodes.get(i).val;
                        nodes.get(i).val = nodes.get(n - 1 - i).val;
                        nodes.get(n - 1 - i).val = temp;
                    }
                }
                nodes.clear();
                size++;
            }
        }
        return head;
    }
}
/*
2074. 反转偶数长度组的节点
https://leetcode.cn/problems/reverse-nodes-in-even-length-groups/

第 267 场周赛 T2。

给你一个链表的头节点 head 。
链表中的节点 按顺序 划分成若干 非空 组，这些非空组的长度构成一个自然数序列（1, 2, 3, 4, ...）。一个组的 长度 就是组中分配到的节点数目。换句话说：
节点 1 分配给第一组
节点 2 和 3 分配给第二组
节点 4、5 和 6 分配给第三组，以此类推
注意，最后一组的长度可能小于或者等于 1 + 倒数第二组的长度 。
反转 每个 偶数 长度组中的节点，并返回修改后链表的头节点 head 。
提示：
链表中节点数目范围是 [1, 10^5]
0 <= Node.val <= 10^5

模拟。链表，双指针。
 */