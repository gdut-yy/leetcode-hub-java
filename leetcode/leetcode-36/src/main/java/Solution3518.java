public class Solution3518 {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int m = n / 2;

        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        if (perm(m, cnt, k) < k) { // k 太大
            return "";
        }

        char[] leftS = new char[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                cnt[j]--; // 假设填字母 j，看是否有足够的排列
                int p = perm(m - i - 1, cnt, k); // 剩余位置的排列个数
                if (p >= k) { // 有足够的排列
                    leftS[i] = (char) ('a' + j);
                    break;
                }
                k -= p; // k 太大，要填更大的字母（类似搜索树剪掉了一个大小为 p 的子树）
                cnt[j]++;
            }
        }

        StringBuilder ans = new StringBuilder(n); // 预分配空间
        ans.append(leftS);
        if (n % 2 != 0) {
            ans.append(s.charAt(m));
        }
        ans.append(new StringBuilder(new String(leftS)).reverse());
        return ans.toString();
    }

    // 为什么这样做是对的？见 62. 不同路径 我的题解
    private int comb(int n, int m, int k) {
        m = Math.min(m, n - m);
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n + 1 - i) / i;
            if (res >= k) { // 太大了
                return k;
            }
        }
        return (int) res;
    }

    // 计算长度为 sz 的字符串的排列个数
    private int perm(int sz, int[] cnt, int k) {
        long res = 1;
        for (int c : cnt) {
            if (c == 0) {
                continue;
            }
            res *= comb(sz, c, k); // 先从 sz 个里面选 c 个位置填当前字母
            if (res >= k) { // 太大了
                return k;
            }
            sz -= c; // 从剩余位置中选位置填下一个字母
        }
        return (int) res;
    }
}
/*
3518. 最小回文排列 II
https://leetcode.cn/problems/smallest-palindromic-rearrangement-ii/description/

第 445 场周赛 T3。

给你一个 回文 字符串 s 和一个整数 k。
返回 s 的按字典序排列的 第 k 小 回文排列。如果不存在 k 个不同的回文排列，则返回空字符串。
注意： 产生相同回文字符串的不同重排视为相同，仅计为一次。
如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。
排列 是字符串中所有字符的重排。
如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
提示：
1 <= s.length <= 10^4
s 由小写英文字母组成。
保证 s 是回文字符串。
1 <= k <= 10^6

试填法 + 组合数学 + 优化
https://leetcode.cn/problems/smallest-palindromic-rearrangement-ii/solutions/3649533/shi-tian-fa-zu-he-shu-xue-pythonjavacgo-qlu6e/
rating 2389 (clist.by)
 */