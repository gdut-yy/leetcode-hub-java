public class Solution3498 {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int pos = i + 1;
            int reverse_degree = 26 - (s.charAt(i) - 'a');
            ans += reverse_degree * pos;
        }
        return ans;
    }
}
/*
3498. 字符串的反转度
https://leetcode.cn/problems/reverse-degree-of-a-string/description/

第 153 场双周赛 T1。

给你一个字符串 s，计算其 反转度。
反转度的计算方法如下：
1.对于每个字符，将其在 反转 字母表中的位置（'a' = 26, 'b' = 25, ..., 'z' = 1）与其在字符串中的位置（下标从1 开始）相乘。
2.将这些乘积加起来，得到字符串中所有字符的和。
返回 反转度。
提示：
1 <= s.length <= 1000
s 仅包含小写字母。

模拟。
时间复杂度 O(n)。
 */