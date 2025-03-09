public class Solution3463 {
    private static final int MX = 5;
    private static final int[][] C = new int[MX][MX];

    static {
        // 预处理组合数
        for (int i = 0; i < MX; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    public boolean hasSameDigits(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int diff = 0;
        for (int i = 0; i < n - 1; i++) {
            diff += comb(n - 2, i) * (s[i] - s[i + 1]);
        }
        return diff % 10 == 0;
    }

    private int comb(int n, int k) {
        // 结果至多为 5 + 4 * 6 = 29，无需中途取模
        return lucas(n, k, 2) * 5 + lucas(n, k, 5) * 6;
    }

    // 计算 C(n, k) % p，要求 p 是质数
    private int lucas(int n, int k, int p) {
        if (k == 0) return 1;
        return C[n % p][k % p] * lucas(n / p, k / p, p) % p;
    }
}
/*
3463. 判断操作后字符串中的数字是否相等 II
https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-ii/description/

第 438 场周赛 T3。

给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
- 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
- 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
如果 s 最后剩下的两个数字相同，则返回 true 。否则，返回 false。
提示：
3 <= s.length <= 10^5
s 仅由数字组成。

扩展 Lucas
https://oi-wiki.org/math/number-theory/lucas/
rating 2298 (clist.by)
 */