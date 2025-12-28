public class Solution3782 {
    public long lastInteger(long n) {
        long start = 1;
        long step = 1;
        long len = n;
        boolean leftToRight = true;
        while (len > 1) {
            if (!leftToRight && len % 2 == 0) {
                start += step;
            }
            step <<= 1;
            len = (len + 1) >> 1;
            leftToRight = !leftToRight;
        }
        return start;
    }
}
/*
3782. 交替删除操作后最后剩下的整数
https://leetcode.cn/problems/last-remaining-integer-after-alternating-deletion-operations/description/

第 172 场双周赛 T4。

给你一个整数 n。
我们将 1 到 n 的整数按从左到右的顺序排成一个序列。然后，交替 地执行以下两种操作，直到只剩下一个整数为止，从操作 1 开始：
- 操作 1：从左侧开始，隔一个数删除一个数。
- 操作 2：从右侧开始，隔一个数删除一个数。
返回最后剩下的那个整数。
提示：
1 <= n <= 10^15

https://chat.deepseek.com/a/chat/s/ebf51d52-96fd-4c67-9a99-1b93633f8a08
我们采用递推方法模拟每次操作后剩余序列的首项、公差和长度。初始序列是首项为1、公差为1、长度为n的等差数列。操作分为两种：
操作1（从左删除）：保留奇数索引项，首项不变，公差乘以2，长度变为ceil(len/2)。
操作2（从右删除）：保留从右数奇数索引项，长度变为ceil(len/2)，公差乘以2，但首项变化取决于当前长度的奇偶性：若长度为偶数，则首项增加当前公差；否则不变。
我们交替执行操作1和操作2，直到序列长度为1，此时首项即为答案。由于每次长度减半，迭代次数为O(log n)，对于n ≤ 10^15高效可行。
 */