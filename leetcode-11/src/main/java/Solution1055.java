public class Solution1055 {
    public int shortestWay(String source, String target) {
        int len1 = source.length();
        int len2 = target.length();
        int p1 = 0;
        int p2 = 0;

        while (p2 < len2) {
            if (source.charAt(p1 % len1) == target.charAt(p2)) {
                p2++;
            }
            p1++;
            // 无法通过串联源字符串中的子序列来构造目标字符串
            if (p1 > len1 * len2) {
                return -1;
            }
        }
        // 数论向上取整法
        return (p1 + len1 - 1) / len1;
    }
}
/*
$1055. 形成字符串的最短路径
https://leetcode.cn/problems/shortest-way-to-form-string/

对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
提示：
source 和 target 两个字符串都只包含 "a"-"z" 的英文小写字母。
source 和 target 两个字符串的长度介于 1 和 1000 之间。

模拟
 */