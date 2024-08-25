package p1624;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1624E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
            }
            String s = scanner.next();
            System.out.println(solve(n, m, a, s));
        }
    }

    private static String solve(int n, int m, String[] a, String s) {
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ai = a[i];
            for (int r = 2; r <= m; r++) {
                map.putIfAbsent(ai.substring(r - 2, r), new int[]{r - 1, r, i});
                if (r > 2) {
                    map.putIfAbsent(ai.substring(r - 3, r), new int[]{r - 2, r, i});
                }
            }
        }

        // 线性 DP
        // f[i] 表示能否拆分 s[:i]，那么 f[i] 从 f[i-2] 或 f[i-3] 转移，需要看末尾能拆出 2 个字符还是 3 个字符。
        // f[0]=true，答案为 f[n]。
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int i = 2; i <= m; i++) {
            f[i] = (f[i - 2] && map.getOrDefault(s.substring(i - 2, i), new int[3])[0] > 0)
                    || (i > 2 && f[i - 3] && map.getOrDefault(s.substring(i - 3, i), new int[3])[0] > 0);
        }
        if (!f[m]) {
            return "-1";
        }

        List<int[]> resList = new ArrayList<>();
        for (int i = m; i > 0; ) {
            if (f[i - 2] && map.getOrDefault(s.substring(i - 2, i), new int[3])[0] > 0) {
                resList.add(map.getOrDefault(s.substring(i - 2, i), new int[3]));
                i -= 2;
            } else {
                resList.add(map.getOrDefault(s.substring(i - 3, i), new int[3]));
                i -= 3;
            }
        }

        Collections.reverse(resList);
        return resList.size()
                + System.lineSeparator()
                + resList.stream().map(o -> o[0] + " " + o[1] + " " + (o[2] + 1)).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
E. Masha-forgetful
https://codeforces.com/contest/1624/problem/E

灵茶の试炼 2023-03-23
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 n*m 之和 ≤1e6。
每组数据输入 n(≤1e3) m(≤1e3) 和长为 n 的字符串数组 a。
然后再输入一个字符串 s。
所有字符串长度均为 m，仅包含 '0'~'9'。
你需要将 s 划分成若干个长度至少为 2 的子串，且每个子串都是某个 a[i] 的子串（不同子串对应的 a[i] 可以不同）。
如果无法划分，输出 -1；否则输出划分出的子串个数 k，然后输出 k 行，每行三个数字 l r i，表示这个子串等于 a[i] 的子串 [l,r]。注意 l r i 的下标均从 1 开始。注意输出的 k 行要与划分的顺序相同。
如果有多种划分方案，输出任意一种。

rating 2000
https://codeforces.com/contest/1624/submission/198571126
提示 1：任意 >=4 的数字都可以拆分为若干 2 和 3 的和。
提示 2：预处理所有长为 2 和 3 的子串及其位置。
提示 3：线性 DP，定义 f[i] 表示能否拆分 s[:i]，那么 f[i] 从 f[i-2] 或 f[i-3] 转移，需要看末尾能拆出 2 个字符还是 3 个字符。
f[0]=true，答案为 f[n]。
由于要输出具体方案，转移时可以记录转移来源，也可以像我代码中那样再算一次从哪转移来的。
相似题目: 2369. 检查数组是否存在有效划分
https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/
======

input
5

4 8
12340219
20215601
56782022
12300678
12345678

2 3
134
126
123

1 4
1210
1221

4 3
251
064
859
957
054

4 7
7968636
9486033
4614224
5454197
9482268
output
3
1 4 1
5 6 2
3 4 3
-1
2
1 2 1
2 3 1
-1
3
1 3 2
5 6 3
3 4 1
 */
