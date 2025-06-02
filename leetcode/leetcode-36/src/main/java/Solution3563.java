public class Solution3563 {
    private char[] s;
    private Boolean[][] memoEmpty;
    private String[] memoDfs;

    public String lexicographicallySmallestString(String S) {
        s = S.toCharArray();
        int n = s.length;
        memoEmpty = new Boolean[n][n];
        memoDfs = new String[n];
        return dfs(0);
    }

    private boolean isConsecutive(char x, char y) {
        int d = Math.abs(x - y);
        return d == 1 || d == 25;
    }

    private boolean canBeEmpty(int i, int j) {
        if (i > j) { // 空串
            return true;
        }
        if (memoEmpty[i][j] != null) return memoEmpty[i][j];

        // 性质 2
        if (isConsecutive(s[i], s[j]) && canBeEmpty(i + 1, j - 1)) {
            return memoEmpty[i][j] = true;
        }

        // 性质 3
        for (int k = i + 1; k < j; k += 2) {
            if (canBeEmpty(i, k) && canBeEmpty(k + 1, j)) {
                return memoEmpty[i][j] = true;
            }
        }

        return memoEmpty[i][j] = false;
    }

    private String dfs(int i) {
        if (i == s.length) {
            return "";
        }
        if (memoDfs[i] != null) return memoDfs[i];

        // 包含 s[i]
        String res = s[i] + dfs(i + 1);

        // 不包含 s[i]，注意 s[i] 不能单独消除，必须和其他字符一起消除
        for (int j = i + 1; j < s.length; j += 2) {
            if (canBeEmpty(i, j)) { // 消除 s[i] 到 s[j]
                String t = dfs(j + 1);
                if (t.compareTo(res) < 0) {
                    res = t;
                }
            }
        }

        return memoDfs[i] = res;
    }
}
/*
3563. 移除相邻字符后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-adjacent-removals/description/

第 451 场周赛 T4。

给你一个由小写英文字母组成的字符串 s。
你可以进行以下操作任意次（包括零次）：
- 移除字符串中 任意 一对 相邻 字符，这两个字符在字母表中是 连续 的，无论顺序如何（例如，'a' 和 'b'，或者 'b' 和 'a'）。
- 将剩余字符左移以填补空隙。
返回经过最优操作后可以获得的 字典序最小 的字符串。
当且仅当在第一个不同的位置上，字符串 a 的字母在字母表中出现的位置早于字符串 b 的字母，则认为字符串 a 的 字典序小于 字符串 b，。
如果 min(a.length, b.length) 个字符都相同，则较短的字符串字典序更小。
注意：字母表被视为循环的，因此 'a' 和 'z' 也视为连续。
提示：
1 <= s.length <= 250
s 仅由小写英文字母组成。

字符消消乐：区间 DP + 线性 DP
https://leetcode.cn/problems/lexicographically-smallest-string-after-adjacent-removals/solutions/3685460/zi-fu-xiao-xiao-le-qu-jian-dp-xian-xing-xmaqk/
时间复杂度 O(n^3)。
rating 2580 (clist.by)
 */