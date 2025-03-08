import java.util.Arrays;

public class Solution3474 {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int total_len = n + m - 1;
        char[] res = new char[total_len];
        Arrays.fill(res, '#');
        boolean[] fixed = new boolean[total_len];

        for (int i = 0; i < n; i++) {
            if (s1[i] == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (pos >= total_len) return "";
                    if (res[pos] != '#' && res[pos] != s2[j]) return "";
                    res[pos] = s2[j];
                    fixed[pos] = true;
                }
            }
        }
        for (int i = 0; i < total_len; i++) {
            if (res[i] == '#') res[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (s1[i] == 'F') {
                boolean equal = true;
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (res[pos] != s2[j]) {
                        equal = false;
                        break;
                    }
                }
                if (!equal) continue;
                boolean modified = false;
                for (int j = 0; j < m; j++) {
                    int pos = (i + m - 1) - j;
                    if (!fixed[pos]) {
                        res[pos] = (s2[j] != 'a') ? 'a' : 'b';
                        modified = true;
                        break;
                    }
                }
                if (!modified) return "";
            }
        }

        for (int i = 0; i < n; i++) {
            if (s1[i] == 'F') {
                boolean equal = true;
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (res[pos] != s2[j]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) return "";
            }
        }
        return new String(res);
    }
}
/*
3474. 字典序最小的生成字符串
https://leetcode.cn/problems/lexicographically-smallest-generated-string/description/

第 439 场周赛 T4。

给你两个字符串，str1 和 str2，其长度分别为 n 和 m 。
如果一个长度为 n + m - 1 的字符串 word 的每个下标 0 <= i <= n - 1 都满足以下条件，则称其由 str1 和 str2 生成：
- 如果 str1[i] == 'T'，则长度为 m 的 子字符串（从下标 i 开始）与 str2 相等，即 word[i..(i + m - 1)] == str2。
- 如果 str1[i] == 'F'，则长度为 m 的 子字符串（从下标 i 开始）与 str2 不相等，即 word[i..(i + m - 1)] != str2。
返回可以由 str1 和 str2 生成 的 字典序最小 的字符串。如果不存在满足条件的字符串，返回空字符串 ""。
如果字符串 a 在第一个不同字符的位置上比字符串 b 的对应字符在字母表中更靠前，则称字符串 a 的 字典序 小于 字符串 b。
如果前 min(a.length, b.length) 个字符都相同，则较短的字符串字典序更小。
子字符串 是字符串中的一个连续、非空 的字符序列。
提示:
1 <= n == str1.length <= 10^4
1 <= m == str2.length <= 500
str1 仅由 'T' 或 'F' 组成。
str2 仅由小写英文字母组成。

贪心 + 暴力匹配。
1. 处理 'T' 条件：遍历第一个字符串的所有位置，如果遇到 'T'，则设置生成的字符串对应位置的字符为第二个字符串的对应字符，并标记这些位置为固定。
2. 填充默认值：将所有未被固定的位置填充为 'a'，以确保字典序最小。
3. 处理 'F' 条件：检查每个 'F' 位置的子字符串是否等于第二个字符串。如果相等，找到最后一个未被固定的位置，将其修改为最小的可能字符，使其不等于对应位置的字符。
4. 最终验证：再次检查所有 'F' 条件，确保所有条件均被满足，否则返回空字符串。
时间复杂度 O(nm)。
rating 2586 (clist.by)
 */