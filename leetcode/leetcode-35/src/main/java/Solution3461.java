public class Solution3461 {
}
/*
3461. 判断操作后字符串中的数字是否相等 I
https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/description/

第 438 场周赛 T1。

给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
- 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
- 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false。
提示：
3 <= s.length <= 100
s 仅由数字组成。

同: 3463. 判断操作后字符串中的数字是否相等 II
https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-ii/description/
 */