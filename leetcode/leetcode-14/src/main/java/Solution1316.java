import java.util.HashSet;
import java.util.Set;

public class Solution1316 {
    private Set<String> vis;

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        vis = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += kmp(text.substring(i));
        }
        return ans;
    }

    private int kmp(String S) {
        int ans = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
            // 以上代码为 KMP 模板

            int m = i + 1;
            if (j != 0 && m % (m - j) == 0 && m / (m - j) % 2 == 0) { // m 需为 m-j 的偶数倍
                String substring = S.substring(0, m / 2);
                if (!vis.contains(substring)) {
                    vis.add(substring);
                    ans++;
                }
            }
        }
        return ans;
    }

    public int distinctEchoSubstrings2(String text) {
        int n = text.length();
        int[] h = new int[n + 1], p = new int[n + 1];
        int base = 131;
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * base + text.charAt(i - 1);
            p[i] = p[i - 1] * base;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j += 2) {
                int len = (j - i + 1) >> 1;

                int hash1 = h[j - len] - h[i - 1] * p[len];
                int hash2 = h[j] - h[j - len] * p[len];

                if (hash1 == hash2 && !set.contains(hash1)) {
                    set.add(hash1);
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
1316. 不同的循环子字符串
https://leetcode.cn/problems/distinct-echo-substrings/description/

给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
- 可以写成某个字符串与其自身相连接的形式（即，可以写为 a + a，其中 a 是某个字符串）。
例如，abcabc 就是 abc 和它自身连接形成的。
提示：
1 <= text.length <= 2000
text 只包含小写英文字母。

字符串哈希、KMP 掌握模板，团灭一众字符匹配问题 https://leetcode.cn/problems/distinct-echo-substrings/solutions/1397548/by-flix-zsuj/
 */