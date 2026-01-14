public class Solution3803 {
    public int residuePrefixes(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        int mask = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int b = ss[i] - 'a';
            mask |= (1 << b);
            int diff = Integer.bitCount(mask);
            if (diff == (i + 1) % 3) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3803. 统计残差前缀
https://leetcode.cn/problems/count-residue-prefixes/description/

第 484 场周赛 T1。

给你一个仅由小写英文字母组成的字符串 s。
如果字符串 s 的某个 前缀 中 不同字符的数量 等于 len(prefix) % 3，则该前缀被称为残差前缀（residue）。
返回字符串 s 中 残差前缀 的数量。
字符串的 前缀 是一个 非空子字符串，从字符串的开头起始并延伸到任意位置。
提示：
1 <= s.length <= 100
s 仅包含小写英文字母。

位运算。
时间复杂度 O(n)。
 */