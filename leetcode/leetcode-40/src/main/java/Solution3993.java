public class Solution3993 {
    public long maximumValue(int n, int s, int m) {
        if (n == 1) return s;
        return s + (long) (n / 2 - 1) * (m - 1) + m;
    }
}
/*
3993. 交替数列的最大元素
https://leetcode.cn/problems/maximum-value-of-an-alternating-sequence/description/

第 187 场双周赛 T2。

给你三个整数 n、s 和 m。
如果一个长度为 n 的整数序列 seq 满足以下条件，则认为它是 有效 的：
- seq[0] = s。
- 序列是 交替 的，这意味着：
  - seq[0] > seq[1] < seq[2] > ...，或者
  - seq[0] < seq[1] > seq[2] < ...。
- 对于每个相邻元素对，|seq[i] - seq[i - 1]| <= m。
长度为 1 的序列被认为是交替的。
返回任何有效序列中可能出现的 最大 元素。
提示：
1 <= n, s <= 10^9
1 <= m <= 10^5

贪心。
时间复杂度 O(1)。
 */