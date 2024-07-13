package template;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 后缀数组
 * https://oi-wiki.org/string/sa/
 */
public class SuffixArray {
    String data;
    int[] rk, old_rk, sa, id, cnt;
    int[] sa0; // 下标从 0 开始
    int[] height;

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
                if (old_rk[sa[i]] == old_rk[sa[i - 1]] && old_rk[sa[i] + w] == old_rk[sa[i - 1] + w])
                    rk[sa[i]] = p;
                else rk[sa[i]] = ++p;
            }
            if (p == n) break; // p = n 时无需再排序
        }
        sa0 = new int[n];
        for (int i = 0; i < n; i++) sa0[i] = sa[i + 1] - 1;
        // height
        height = new int[n + 1];
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (rk[i] == 1) continue;
            if (k > 0) --k;
            int j = sa[rk[i] - 1];
            while (i + k <= n && j + k <= n && s[i + k] == s[j + k]) k++;
            height[rk[i]] = k;
        }
    }

    // O(log(N)*len(s))
    int[] lookupAll(String s) {
        int i = sortSearch(sa0.length, m -> compareTo(data, sa0[m], s) >= 0);
        int j = i + sortSearch(sa0.length - i, m -> !data.startsWith(s, sa0[m + i]));
        return new int[]{i, j};
    }

    private int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 等价于 s.substring(beginIndex).compareTo(t)
    private int compareTo(String s, int beginIndex, String t) {
        int len1 = s.length() - beginIndex, len2 = t.length();
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            char c1 = s.charAt(k + beginIndex), c2 = t.charAt(k);
            if (c1 != c2) return c1 - c2;
        }
        return len1 - len2;
    }
}
