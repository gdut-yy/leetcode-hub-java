import java.util.Arrays;

public class SolutionP3735 {
    int[] sa, rank, height;
    SparseTable st;

    public String lexSmallest(String s) {
        String t = new StringBuilder(s).reverse() + "#" + s;

        SuffixArray suffixArray = new SuffixArray(t);
        this.sa = suffixArray.sa0;
        this.rank = suffixArray.rk0;
        this.height = suffixArray.height0;

        int n = s.length();
        st = new SparseTable(height);

        // 反转前缀
        int ansK = 1;
        for (int k = 2; k <= n; k++) {
            int c = compareSubstring(n - k, n - k + ansK, n - ansK, n);
            if (c < 0 || c == 0 && compareSubstring(n - k + ansK, n, n + 1 + ansK, n + 1 + k) < 0) {
                ansK = k;
            }
        }
        String pre = new StringBuilder(s.substring(0, ansK)).reverse().toString();
        String ans = pre + s.substring(ansK);

        // 反转真后缀
        // 剪枝：如果 s[0] > ans[0]，那么反转真后缀一定不优
        if (s.charAt(0) == ans.charAt(0)) {
            ansK = 1;
            for (int k = 2; k < n; k++) {
                int c = compareSubstring(0, k - ansK, n * 2 + 1 - k, n * 2 + 1 - ansK);
                if (c < 0 || c == 0 && compareSubstring(k - ansK, k, 0, ansK) < 0) {
                    ansK = k;
                }
            }
            String suf = new StringBuilder(s.substring(n - ansK)).reverse().toString();
            String res = s.substring(0, n - ansK) + suf;
            if (res.compareTo(ans) < 0) {
                ans = res;
            }
        }
        return ans;
    }

    private int lcp(int i, int j) {
        if (i == j) {
            return sa.length - i;
        }
        // 将 s[i:] 和 s[j:] 通过 rank 数组映射为 height 的下标
        int ri = rank[i], rj = rank[j];
        if (ri > rj) {
            // ri, rj = rj, ri
            ri = rank[j];
            rj = rank[i];
        }
        // ri+1 是因为 height 的定义是 sa[i] 和 sa[i-1]
        // rj+1 是因为 query 是左闭右开
        return st.query(ri + 1, rj + 1);
    }

    private int compareSubstring(int l1, int r1, int l2, int r2) {
        int len1 = r1 - l1, len2 = r2 - l2;
        int l = lcp(l1, l2);
        if (l >= Math.min(len1, len2)) {
            // 一个是子串另一个子串的前缀，或者完全相等
            return len1 - len2;
        }
        // 此时两个子串一定不相等
        return rank[l1] - rank[l2]; // 也可以写 int(s[l1+l]) - int(s[l2+l])
    }

    static class SuffixArray {
        String data;
        int[] rk, old_rk, sa, id, cnt;
        int[] sa0, height0, rk0; // 下标从 0 开始

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
            rk0 = new int[n];
            for (int i = 0; i < n; i++) rk0[i] = rk[i + 1] - 1;
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

    static class SparseTable {
        private final int[][] st;

        SparseTable(int[] a) {
            int n = a.length - 1;
            int sz = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[n][sz];
            for (int i = 0; i < n; i++) {
                st[i][0] = a[i];
            }
            for (int j = 1; j < sz; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        int query(int l, int r) {
            if (l >= r) {
                return 0;
            }
            int k = 32 - Integer.numberOfLeadingZeros(r - l) - 1;
            return Math.min(st[l][k], st[r - (1 << k)][k]);
        }
    }
}
/*
$3735. 反转后字典序最小的字符串 II
https://leetcode.cn/problems/lexicographically-smallest-string-after-reverse-ii/description/

给你一个由小写英文字母组成的、长度为 n 的字符串 s。
你 必须执行 恰好 一次操作：选择一个整数 k，满足 1 <= k <= n，然后执行以下两个选项之一：
- 反转 s 的 前 k 个字符，或
- 反转 s 的 后 k 个字符。
返回在 恰好 执行一次此类操作后可以获得的 字典序最小 的字符串。
如果字符串 a 和字符串 b 在第一个不同的位置上，a 中的字母在字母表中比 b 中对应的字母出现得更早，则称字符串 a 字典序小于 字符串 b。如果前 min(a.length, b.length) 个字符都相同，则较短的字符串字典序较小。
提示:
1 <= n == s.length <= 10^5
s 由小写英文字母组成。

后缀数组。
https://leetcode.cn/problems/lexicographically-smallest-string-after-reverse/solutions/3815537/mei-ju-hou-zhui-shu-zu-pythonjavacgo-by-9pwcs/
时间复杂度 O(nlogn)。
相似题目: 3722. 反转后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-reverse/description/
 */