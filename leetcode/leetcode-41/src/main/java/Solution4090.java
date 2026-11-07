public class Solution4090 {
}
/*
4090. 统计神奇子字符串对 I
https://leetcode.cn/problems/count-magical-substring-pairs-i/description/

第 194 场双周赛 T3。

给你一个长度为 n 且仅由小写英文字母组成的字符串 s。
对于满足 0 <= i <= j < k < n 的每一个下标三元组 (i, j, k)，定义：
- s1 = s[i..j]
- s2 = s[j + 1..k]
如果 s1 中 不同 字符的数量 等于 s2 中 不同 字符的数量，则称这对 子字符串 (s1, s2) 是 神奇 的。
返回满足 (s1, s2) 是 神奇 对的 三元组 (i, j, k) 的数量。
子字符串 是字符串中连续的 非空 字符序列。
示例 1：
输入： s = "aba"
输出： 2
示例 2：
输入： s = "kkk"
输出： 4
示例 3：
输入： s = "abcac"
输出： 7
提示：
2 <= s.length <= 2000
s 仅由小写英文字母组成。

同: 4090. 统计神奇子字符串对 I
https://leetcode.cn/problems/count-magical-substring-pairs-i/description/
 */
