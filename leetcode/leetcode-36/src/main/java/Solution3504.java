import java.util.Arrays;

public class Solution3504 {
    // 灵神 O(nm + n^2 + m^2)
    static class V1 {
        private int calc(String S, String T) {
            int ans = 0;
            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int n = s.length;
            int m = t.length;
            int[] mx = new int[n + 1];
            int[][] f = new int[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (s[i] == t[j]) {
                        f[i + 1][j] = f[i][j + 1] + 1;
                        mx[i + 1] = Math.max(mx[i + 1], f[i + 1][j]);
                    }
                }
                ans = Math.max(ans, mx[i + 1] * 2); // |x| = |y| 的情况
            }

            // 计算 |x| > |y| 的情况，中心扩展法
            for (int i = 0; i < 2 * n - 1; i++) {
                int l = i / 2, r = (i + 1) / 2;
                while (l >= 0 && r < n && s[l] == s[r]) {
                    l--;
                    r++;
                }
                if (l + 1 <= r - 1) { // s[l+1] 到 s[r-1] 是非空回文串
                    ans = Math.max(ans, r - l - 1 + mx[l + 1] * 2);
                }
            }
            return ans;
        }

        public int longestPalindrome(String s, String t) {
            String revS = new StringBuilder(s).reverse().toString();
            String revT = new StringBuilder(t).reverse().toString();
            return Math.max(calc(s, t), calc(revT, revS));
        }
    }

    // 后缀数组 + 高度数组 + Manacher 算法
    // O(n + m)
    static class V2 {
        public int longestPalindrome(String s, String t) {
            String revS = new StringBuilder(s).reverse().toString();
            String revT = new StringBuilder(t).reverse().toString();
            return Math.max(calc(s, t), calc(revT, revS));
        }

        private int calc(String S, String T) {
            String ts = T + "#" + new StringBuilder(S).reverse();
            SuffixArray suffixArray = new SuffixArray(ts);
            int[] sa = suffixArray.sa0;
            int[] height = suffixArray.height0;

            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int[] mx = new int[s.length + 1];

            int lcp = 0;
            // sa[0] 对应 '#' 开头的后缀，不遍历
            for (int i = 1; i < sa.length; i++) {
                if (sa[i] < t.length) {
                    lcp = Integer.MAX_VALUE; // 找到了 t 中的后缀，可以开始计算 LCP
                } else {
                    lcp = Math.min(lcp, height[i]);
                    mx[sa[i] - t.length - 1] = lcp;
                }
            }
            lcp = 0;
            for (int i = sa.length - 1; i > 0; i--) { // 反着再来一遍
                if (sa[i] < t.length) {
                    lcp = Integer.MAX_VALUE;
                } else {
                    lcp = Math.min(lcp, height[i + 1]);
                    int j = sa[i] - t.length - 1;
                    mx[j] = Math.max(mx[j], lcp);
                }
            }
            reverse(mx);
            int ans = Arrays.stream(mx).max().orElseThrow() * 2; // |x| = |y| 的情况

            // 计算 |x| > |y| 的情况
            StringBuilder s2 = new StringBuilder("^");
            for (char c : s) s2.append("#").append(c);
            s2.append("#$");
            int[] halfLen = new int[s2.length() - 2];
            halfLen[1] = 1;
            int boxM = 0, boxR = 0;
            for (int i = 2; i < halfLen.length; i++) {
                int hl = 1;
                if (i < boxR) hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
                while (s2.charAt(i - hl) == s2.charAt(i + hl)) {
                    hl++;
                    boxM = i;
                    boxR = i + hl;
                }
                halfLen[i] = hl;
                if (hl > 1) { // 回文子串不为空
                    int l = (i - hl) / 2; // 回文子串左端点
                    ans = Math.max(ans, hl - 1 + mx[l] * 2);
                }
            }
            return ans;
        }

        private void reverse(int[] arr) {
            for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }

        static class SuffixArray {
            String data;
            int[] rk, old_rk, sa, id, cnt;
            int[] sa0, height0; // 下标从 0 开始

            public SuffixArray(String S) {
                data = S;
                int n = S.length(), m = 128, p;
                rk = new int[n * 2 + 1];
                old_rk = new int[n * 2 + 1];
                id = new int[n + 1];
                cnt = new int[Math.max(n + 1, m + 1)];
                sa = new int[n + 1];
                S = " " + S;
                char[] s = S.toCharArray();
                for (int i = 1; i <= n; i++) cnt[rk[i] = s[i]]++;
                for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
                for (int i = n; i >= 1; i--) sa[cnt[rk[i]]--] = i;
                for (int w = 1; ; w <<= 1, m = p) { // m = p 即为值域优化
                    int cur = 0;
                    for (int i = n - w + 1; i <= n; i++) id[++cur] = i;
                    for (int i = 1; i <= n; i++) {
                        if (sa[i] > w) id[++cur] = sa[i] - w;
                    }
                    Arrays.fill(cnt, 0);
                    for (int i = 1; i <= n; i++) cnt[rk[i]]++;
                    for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
                    for (int i = n; i >= 1; i--) sa[cnt[rk[id[i]]]--] = id[i];
                    p = 0;
                    System.arraycopy(rk, 0, old_rk, 0, old_rk.length);
                    for (int i = 1; i <= n; i++) {
                        if (old_rk[sa[i]] == old_rk[sa[i - 1]] && old_rk[sa[i] + w] == old_rk[sa[i - 1] + w]) {
                            rk[sa[i]] = p;
                        } else rk[sa[i]] = ++p;
                    }
                    if (p == n) break; // p = n 时无需再排序
                }
                sa0 = new int[n];
                for (int i = 0; i < n; i++) sa0[i] = sa[i + 1] - 1;
                height0 = new int[n + 1];
                int k = 0;
                for (int i = 1; i <= n; i++) {
                    if (rk[i] == 1) continue;
                    if (k > 0) --k;
                    int j = sa[rk[i] - 1];
                    while (i + k <= n && j + k <= n && s[i + k] == s[j + k]) k++;
                    height0[rk[i] - 1] = k;
                }
            }
        }
    }
}
/*
3504. 子字符串连接后的最长回文串 II
https://leetcode.cn/problems/longest-palindrome-after-substring-concatenation-ii/description/

第 443 场周赛 T3。

给你两个字符串 s 和 t。
你可以从 s 中选择一个子串（可以为空）以及从 t 中选择一个子串（可以为空），然后将它们 按顺序 连接，得到一个新的字符串。
返回可以由上述方法构造出的 最长 回文串的长度。
回文串 是指正着读和反着读都相同的字符串。
子字符串 是指字符串中的一个连续字符序列。
提示：
1 <= s.length, t.length <= 1000
s 和 t 仅由小写英文字母组成。

枚举回文中心 + DP，附后缀数组 + Manacher 线性做法
相似题目: 3503. 子字符串连接后的最长回文串 I
https://leetcode.cn/problems/longest-palindrome-after-substring-concatenation-i/description/
rating 2399 (clist.by)
 */