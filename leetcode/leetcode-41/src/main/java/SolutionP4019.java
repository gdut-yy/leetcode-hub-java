import java.util.Arrays;

public class SolutionP4019 {
    private final static int INF = (int) 1e9;

    public String mergeCharacters(String s, int k) {
        int[] last = new int[26];
        Arrays.fill(last, -INF);

        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            // ch 在 ans 中的下标是 ans.length()
            if (ans.length() - last[ch - 'a'] > k) {
                last[ch - 'a'] = ans.length();
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
/*
$4019. 合并靠近字符 II
https://leetcode.cn/problems/merge-close-characters-ii/description/

给定一个由小写英文字母组成的字符串 s 和一个整数 k。
如果两个相同的字符 s[i] 和 s[j] 满足 0 <= i < j < s.length 且 j - i <= k，则认为它们是 靠近 的。所有下标均指 当前 字符串中的下标。
重复执行以下操作，直到不存在靠近字符对：
- 在所有靠近字符对 (i, j) 中，选择 i 最小的那一对。如果存在多个具有相同 i 的靠近字符对，则选择 j 最小的那一对。
- 将右侧字符合并到左侧字符中，即从 s 中删除 s[j]。字符 s[i] 保持不变，其余字符重新编号。
返回执行所有可能的合并操作后得到的字符串。
示例 1：
输入： s = "abca", k = 3
输出： "abc"
示例 2：
输入： s = "aabca", k = 2
输出： "abca"
示例 3：
输入： s = "yybyzybz", k = 2
输出： "ybzybz"
提示：
1 <= s.length <= 5 * 10^5
1 <= k <= s.length
s 由小写英文字母组成。

相似题目: 3853. 合并靠近字符
https://leetcode.cn/problems/merge-close-characters/description/
 */