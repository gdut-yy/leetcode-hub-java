public class Solution3746 {
    public int minLengthAfterRemovals(String s) {
        int dab = 0; // a 和 b 的差值
        for (char c : s.toCharArray()) {
            if (c == 'a') dab++;
            else dab--;
        }
        return Math.abs(dab);
    }
}
/*
3746. 等量移除后的字符串最小长度
https://leetcode.cn/problems/minimum-string-length-after-balanced-removals/description/

第 476 场周赛 T2。

给你一个仅由字符 'a' 和 'b' 组成的字符串 s。
你可以反复移除 任意子字符串 ，只要该子字符串中 'a' 和 'b' 的数量相等。每次移除后，剩余部分的字符串将无缝拼接在一起。
返回一个整数，表示经过任意次数的操作后，字符串可能的 最小长度 。
子字符串 是字符串中一个连续、非空的字符序列。
提示：
1 <= s.length <= 10^5
s[i] 是 'a' 或 'b'。

脑筋急转弯。
赛时看错成 只能移除一次。那就是前缀和首次出现位置的题目。
时间复杂度 O(n)。
 */