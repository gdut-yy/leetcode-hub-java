public class Solution955 {
}
/*
955. 删列造序 II
https://leetcode.cn/problems/delete-columns-to-make-sorted-ii/

给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
提示：
n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 100
strs[i] 由小写英文字母组成
 */