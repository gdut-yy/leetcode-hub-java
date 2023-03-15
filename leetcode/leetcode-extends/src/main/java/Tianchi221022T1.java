public class Tianchi221022T1 {
    public int numberEvenListNode(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt += head.val % 2;
            head = head.next;
        }
        return cnt;
    }
}
/*
「天池 X LeetCode」在线编程专场选拔赛
221021天池-01. 统计链表奇数节点
https://leetcode.cn/contest/tianchi2022/problems/yGdjWb/

给你一个链表的头节点 head，请统计链表中值为 奇数 的节点个数
示例 1：
输入：head = [2,1,8]
输出：1
解释：链表中存在 1 个奇数值的节点，值为 1
示例 2：
输入：head = [1,2,3,4]
输出：2
解释：链表中存在 2 个奇数值的节点，值分别为 1、3
提示：
链表中节点的数目在 [1, 5000] 范围内。
1 <= Node.val <= 10000

模拟
 */